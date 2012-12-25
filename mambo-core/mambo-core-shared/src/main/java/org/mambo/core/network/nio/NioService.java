package org.mambo.core.network.nio;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractIdleService;
import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;
import org.mambo.core.concurrent.Worker;
import org.mambo.core.io.DataReaderInterface;
import org.mambo.core.io.DataWriterInterface;
import org.mambo.core.network.*;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * single threaded nio {@link NetworkService}
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 02/12/12
 * Time: 10:52
 */
public abstract class NioService<T extends NetworkClient> extends AbstractIdleService implements NetworkService {
    private final Set<T> clients = Sets.newHashSet();
    private final Logger log;
    private final int port, initialCapacity;
    private final NetworkProtocol protocol;
    private final NetworkHandlerManager<T> handlerManager;

    private int largestOnlineClients;
    private Instant startupInstant;
    private boolean running;

    private InputWorker inputWorker;
    private OutputWorker outputWorker;

    public NioService(@NotNull Logger log, int port, int initialCapacity, @NotNull NetworkProtocol protocol, @NotNull NetworkHandlerManager<T> handlerManager) {
        this.log = checkNotNull(log);
        this.port = port;
        this.initialCapacity = initialCapacity;
        this.protocol = checkNotNull(protocol);
        this.handlerManager = checkNotNull(handlerManager);
    }

    @NotNull
    @Override
    public ImmutableSet<T> getOnlineClients() {
        return ImmutableSet.copyOf(clients);
    }

    @Override
    public int getLargestOnlineClients() {
        return largestOnlineClients;
    }

    @Override
    public Instant getStartupInstant() {
        return startupInstant;
    }

    @NotNull
    @Override
    public NetworkProtocol getProtocol() {
        return protocol;
    }

    @NotNull
    @Override
    public NetworkHandlerManager<T> getHandlerManager() {
        return handlerManager;
    }

    @Override
    protected void startUp() throws Exception {
        inputWorker = new InputWorker();
        outputWorker = new OutputWorker();

        inputWorker.start();
        outputWorker.start();

        running = true;
        startupInstant = Instant.now();
    }

    @Override
    protected void shutDown() throws Exception {
        running = false;

        outputWorker.shutdown();
        inputWorker.shutdown();
    }

    /**
     * create a non-null client
     * @param session handle to write and close to socket
     * @return a non-null client
     */
    @NotNull
    protected abstract T newClient(@NotNull NetworkSession session);

    private void addClient(T client) {
        clients.add(client);
        if (largestOnlineClients < clients.size()) {
            largestOnlineClients = clients.size();
        }
    }

    private void removeClient(T client) {
        clients.remove(client);
    }

    void addRequest(Request request) {
        outputWorker.addRequest(request);
    }

    void handleException(Throwable t) {
        log.error("unhandled exception catched", t);
    }

    private class Token {
        final NioSession session;
        final T client;
        final ByteBuffer buffer = ByteBuffer.allocate(initialCapacity);

        Token(NioSession session, T client) {
            this.session = session;
            this.client = client;
        }
    }

    private class InputWorker extends Worker {
        ServerSocketChannel server;
        Selector selector;

        void accept() throws IOException {
            SocketChannel accepted = server.accept();
            NioSession session = new NioSession(NioService.this, accepted, accepted.getRemoteAddress());
            T client = newClient(session);

            accepted.configureBlocking(false);
            SelectionKey key = accepted.register(selector, SelectionKey.OP_READ);
            key.attach(new Token(session, client));

            addClient(client);
            log.debug("client {} is connected", session.getRemoteAddress());
            handlerManager.dispatchConnected(client);
        }

        void read(SelectionKey key) throws IOException {
            Token token = getToken(key);

            ByteBuffer buffer = token.buffer;
            int read = token.session.getChannel().read(buffer);

            if (read < 0) {
                token.session.close();
            } else {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    DataReaderInterface reader = protocol.newReader(buffer.array(), buffer.position());

                    Object message = protocol.getDecoder().decode(reader);
                    if (message == null) {
                        break;
                    }
                    buffer.position(reader.getOffset());

                    log.debug("receive {} from {}", message, token.session.getRemoteAddress());
                    handlerManager.dispatchMessage(token.client, message);
                }
                buffer.flip();
            }
        }

        @SuppressWarnings("unchecked")
        Token getToken(SelectionKey key) {
            return (Token) key.attachment();
        }

        SelectionKey getSelectionKey(SocketChannel channel) {
            return channel.keyFor(selector);
        }

        @Override
        protected void run() {
            log.debug("input worker started");
            while (running) {
                try {
                    selector.select();

                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();

                        if (key.isAcceptable()) {
                            accept();
                        } else if (key.isReadable()) {
                            read(key);
                        }
                    }
                } catch (IOException ioe) {
                    log.error("I/O exception, shutting down");
                    triggerShutdown();
                } catch (Throwable t) {
                    handleException(t);
                }
            }
        }

        @Override
        protected void triggerShutdown() {
            running = false;
        }

        @Override
        protected void setUp() {
            try {
                server = ServerSocketChannel.open();
                selector = Selector.open();

                server.configureBlocking(false);
                server.register(selector, SelectionKey.OP_ACCEPT);
                server.bind(new InetSocketAddress(port));
            } catch (IOException e) {
                throw new RuntimeException("can't open server or selector");
            }
        }

        @Override
        protected void tearDown() {
            if (selector != null) {
                try {
                    selector.close();
                } catch (Throwable ignored) { }

                selector = null;
            }

            if (server != null) {
                try {
                    server.socket().close();
                    server.close();
                } catch (Throwable ignored) {}

                server = null;
            }
        }
    }

    private class OutputWorker extends Worker {
        Queue<Request> requests;
        Lock lock = new ReentrantLock();

        void addRequest(Request request) {
            lock.lock();
            try {
                requests.offer(request);
            } finally {
                lock.unlock();
            }
        }

        void waitForRequests() {
            try {
                while (requests.isEmpty()) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException ignored) {}
        }

        void write(Request.Write request) throws IOException {
            if (!protocol.canHandle(request.getMessage())) {
                log.warn("can't handle message \"" + request.getMessage() + "\"");
                return;
            }

            DataWriterInterface writer = protocol.getEncoder().encode(request.getMessage());
            ByteBuffer buffer = ByteBuffer.wrap(writer.getData());

            SocketChannel channel = request.getSession().getChannel();
            channel.write(buffer);

            log.debug("send {} to {}", request.getMessage(), request.getSession().getRemoteAddress());
            request.getFuture().set(request.getSession());
        }

        void close(Request.Close request) throws IOException {
            if (request.getSession().getCloseFuture().isDone()) return;

            SelectionKey key = inputWorker.getSelectionKey(request.getSession().getChannel());
            Token token = inputWorker.getToken(key);

            key.cancel();
            key.attach(null);
            token.session.getChannel().close();
            request.getFuture().set(token.session);

            removeClient(token.client);
            log.debug("client {} is disconnected", token.session.getRemoteAddress());
            handlerManager.dispatchDisconnected(token.client);
        }

        @Override
        protected void run() {
            log.debug("output worker started");
            while (running) {
                waitForRequests();

                lock.lock();
                try {
                    while (!requests.isEmpty()) {
                        Request request = requests.poll();
                        if (request instanceof Request.Write) {
                            write((Request.Write) request);
                        } else if (request instanceof Request.Close) {
                            close((Request.Close) request);
                        }
                    }
                } catch (IOException e) {
                    log.error("unhandled I/O exception, try to shutdown", e);
                    triggerShutdown();
                } catch (Throwable t) {
                    handleException(t);
                } finally {
                    lock.unlock();
                }
            }
        }

        @Override
        protected void triggerShutdown() {
            running = false;
        }

        @Override
        protected void setUp() {
            requests = Queues.newArrayDeque();
        }

        @Override
        protected void tearDown() {
            requests.clear();
            requests = null;
        }
    }
}

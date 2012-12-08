package org.mambo.core.network.nio;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.SettableFuture;
import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;
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
public abstract class NioService<T extends NetworkClient> extends AbstractExecutionThreadService implements NetworkService {
    private final Set<T> clients = Sets.newHashSet();
    private final Logger log;
    private final int port, initialCapacity;
    private final NetworkProtocol protocol;
    private final NetworkHandlerManager<T> handlerManager;

    private int largestOnlineClients;
    private Instant startupInstant;
    private boolean running;

    private ServerSocketChannel server;
    private Selector selector;

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
        server = ServerSocketChannel.open();
        selector = Selector.open();

        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        server.bind(new InetSocketAddress(port));

        startupInstant = Instant.now();
        running = true;
    }

    @Override
    protected void triggerShutdown() {
        running = false;
    }

    @Override
    protected void shutDown() throws Exception {
        if (selector != null) {
            selector.close();
        }
        if (server != null) {
            server.socket().close();
            server.close();
        }
    }

    private void forceShutDown() {
        throw new RuntimeException("forced shutdown");
    }

    @Override
    protected void run() throws Exception {
        while (running) {
            try {
                selector.select();
                Iterator<SelectionKey> it = selector.keys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable()) {
                        accept();
                    } else if (key.isReadable()) {
                        read(key);
                    } else if (key.isWritable()) {
                        write(key);
                    }
                }
            } catch (IOException ioe) {
                log.error("Unhandled IOException catched, shutting down the server", ioe);
                triggerShutdown();
            } catch (Throwable t) {
                exception(t);
            }
        }

        forceShutDown();
    }

    void write(NioSession session, Object message, SettableFuture<NioSession> future) {
        SelectionKey key = session.getChannel().keyFor(selector);
        @SuppressWarnings("unchecked")
        Attachement attachement = (Attachement) key.attachment();

        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        attachement.writeRequestsLock.lock();
        try {
            attachement.writeRequests.offer(new WriteRequest(message, future));
        } finally {
            attachement.writeRequestsLock.unlock();
        }
    }

    void close(NioSession session) throws IOException {
        SelectionKey key = session.getChannel().keyFor(selector);
        @SuppressWarnings("unchecked")
        Attachement attachement = (Attachement) key.attachment();

        key.cancel();
        key.attach(null);
        session.getChannel().close();

        handlerManager.dispatchDisconnected(attachement.client);
    }

    void exception(Throwable t) {
        log.error("Unhandled exception catched", t);
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

    private void accept() throws IOException {
        SocketChannel channel = server.accept();
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);

        NioSession session = new NioSession(this, channel, channel.getRemoteAddress());
        T client = newClient(session);

        key.attach(new Attachement(session, client));

        addClient(client);
        handlerManager.dispatchConnected(client);
    }

    private void read(SelectionKey key) throws IOException {
        @SuppressWarnings("unchecked")
        Attachement attachement = (Attachement) key.attachment();

        NioSession session = attachement.session;
        ByteBuffer buffer = attachement.buffer;

        int read = session.getChannel().read(buffer);

        if (read < 0) {
            close(session);
        } else {
            while (buffer.hasRemaining()) {
                DataReaderInterface reader = protocol.newReader(buffer.array(), buffer.position());
                Object message = protocol.getDecoder().decode(reader);

                if (message == null) {
                    break;
                } else {
                    buffer.position(reader.getOffset());

                    handlerManager.dispatchMessage(attachement.client, message);
                }
            }
        }
    }

    private void write(SelectionKey key) throws IOException {
        @SuppressWarnings("unchecked")
        Attachement attachement = (Attachement) key.attachment();

        Queue<WriteRequest> writeRequests = attachement.writeRequests;
        NioSession session = attachement.session;

        attachement.writeRequestsLock.lock();
        try {
            while (!writeRequests.isEmpty()) {
                WriteRequest request = writeRequests.poll();

                DataWriterInterface writer = protocol.getEncoder().encode(request.message); // TODO performance improvement
                session.getChannel().write(ByteBuffer.wrap(writer.getData()));

                request.future.set(session);
            }
        } finally {
            attachement.writeRequestsLock.unlock();
            key.interestOps(SelectionKey.OP_READ);
        }
    }

    private final class Attachement {
        final NioSession session;
        final T client;
        final ByteBuffer buffer = ByteBuffer.allocate(initialCapacity);
        final Queue<WriteRequest> writeRequests = Queues.newArrayDeque();
        final Lock writeRequestsLock = new ReentrantLock();

        private Attachement(NioSession session, T client) {
            this.session = session;
            this.client = client;
        }
    }

    private final class WriteRequest {
        final Object message;
        final SettableFuture<NioSession> future;

        private WriteRequest(Object message, SettableFuture<NioSession> future) {
            this.message = message;
            this.future = future;
        }
    }
}

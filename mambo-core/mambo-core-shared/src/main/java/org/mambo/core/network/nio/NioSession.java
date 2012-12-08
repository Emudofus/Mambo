package org.mambo.core.network.nio;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkSession;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 17:46
 */
class NioSession implements NetworkSession {
    private final NioService<?> service;
    private final SocketChannel channel;
    private final SocketAddress address;

    NioSession(NioService<?> service, SocketChannel channel, SocketAddress address) {
        this.service = service;
        this.channel = channel;
        this.address = address;
    }

    @NotNull
    SocketChannel getChannel() {
        return channel;
    }

    @NotNull
    @Override
    public ListenableFuture<NioSession> write(@NotNull Object msg) {
        SettableFuture<NioSession> future = SettableFuture.create();
        service.write(this, msg, future);
        return future;
    }

    @NotNull
    @Override
    public ListenableFuture<NioSession> close() {
        SettableFuture<NioSession> future = SettableFuture.create();
        try {
            service.close(this);
            future.set(this);
        } catch (IOException e) {
            future.setException(e);
        }
        return future;
    }

    @Override
    public void closeAndWait() {
        try {
            ListenableFuture<NioSession> future = close();
            future.get();
        } catch (Throwable t) {
            service.exception(t);
        }
    }

    @NotNull
    @Override
    public SocketAddress getRemoteAddress() {
        return address;
    }
}

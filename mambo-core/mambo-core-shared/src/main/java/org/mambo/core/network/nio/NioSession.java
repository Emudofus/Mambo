package org.mambo.core.network.nio;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkSession;

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
        Request request = Request.write(this, msg);
        service.addRequest(request);
        return request.getFuture();
    }

    @NotNull
    @Override
    public ListenableFuture<NioSession> close() {
        Request request = Request.close(this);
        service.addRequest(request);
        return request.getFuture();
    }

    @Override
    public void closeAndWait() {
        Futures.getUnchecked(close());
    }

    @NotNull
    @Override
    public SocketAddress getRemoteAddress() {
        return address;
    }
}

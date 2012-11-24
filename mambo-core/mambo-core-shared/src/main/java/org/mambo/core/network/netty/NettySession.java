package org.mambo.core.network.netty;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.mambo.core.NotNull;
import org.mambo.core.network.NetworkSession;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 14:49
 */
public class NettySession implements NetworkSession {
    private final Channel channel;

    public NettySession(@NotNull Channel channel) {
        this.channel = checkNotNull(channel);
    }

    @NotNull
    public Channel getChannel() {
        return channel;
    }

    @NotNull
    @Override
    public ListenableFuture<NettySession> write(@NotNull Object msg) {
        Future future = new Future();
        channel.write(msg).addListener(future);
        return future;
    }

    @NotNull
    @Override
    public ListenableFuture<? extends NetworkSession> close() {
        Future future = new Future();
        channel.close().addListener(future);
        return future;
    }

    @Override
    public void closeAndWait() {
        try {
            close().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class Future extends AbstractFuture<NettySession> implements ChannelFutureListener {
        public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
                set(NettySession.this);
            } else {
                setException(future.getCause());
            }
        }
    }
}

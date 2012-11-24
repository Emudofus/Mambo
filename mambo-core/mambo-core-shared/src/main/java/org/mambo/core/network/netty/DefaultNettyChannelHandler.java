package org.mambo.core.network.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 20/11/12
 * Time: 20:58
 */
public class DefaultNettyChannelHandler<T extends NetworkClient> extends SimpleChannelHandler {
    private final NettyService<T> service;

    public DefaultNettyChannelHandler(@NotNull NettyService<T> service) {
        this.service = checkNotNull(service);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    protected T getClient(ChannelHandlerContext ctx) {
        return (T) checkNotNull(ctx.getChannel().getAttachment());
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        T client = getClient(ctx);
        service.getHandlerManager().dispatchConnected(client);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        T client = getClient(ctx);
        service.getHandlerManager().dispatchDisconnected(client);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        @SuppressWarnings("unchecked")
        T client = (T) checkNotNull(ctx.getChannel().getAttachment()); // see NettyService.Handler
        Object message = checkNotNull(e.getMessage());

        service.getHandlerManager().dispatchMessage(client, message);
    }
}

package org.mambo.core.network.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkProtocol;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 18:58
 */
public class NettyProtocolAdapter extends FrameDecoder implements ChannelDownstreamHandler {
    private final NetworkProtocol protocol;

    public NettyProtocolAdapter(@NotNull NetworkProtocol protocol) {
        this.protocol = checkNotNull(protocol);
    }

    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (!(e instanceof MessageEvent)) {
            ctx.sendDownstream(e);
            return;
        }

        MessageEvent msgEvent = (MessageEvent) e;
        Object msg = msgEvent.getMessage();
        byte[] bytes = protocol.getEncoder().encode(msg);

        if (bytes == null) {
            ctx.sendDownstream(e);
            return;
        }

        Channels.write(ctx, e.getFuture(), ChannelBuffers.wrappedBuffer(bytes));
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
        return protocol.getDecoder().decode(buffer.array());
    }
}

package org.mambo.core.network.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.io.DataReaderInterface;
import org.mambo.core.io.DataWriterInterface;
import org.mambo.core.network.NetworkProtocol;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 18:58
 */
public class NettyProtocolAdapter implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    private final NetworkProtocol protocol;
    private final ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();

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

        DataWriterInterface writer = protocol.getEncoder().encode(msg);
        if (writer == null) { // can't encode message => delegate to another handler
            ctx.sendDownstream(e);
        } else { // successfully encoded message => send it
            Channels.write(ctx, e.getFuture(), ChannelBuffers.wrappedBuffer(writer.getData()));
        }
    }

    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (!(e instanceof MessageEvent)) {
            ctx.sendUpstream(e);
            return;
        }

        MessageEvent msgEvent = (MessageEvent) e;
        if (!(msgEvent.getMessage() instanceof ChannelBuffer)) {
            ctx.sendUpstream(e);
            return;
        }

        buffer.writeBytes((ChannelBuffer) msgEvent.getMessage()); // add received bytes

        buffer.readerIndex(0); // return to start
        while (buffer.readableBytes() > 0) {
            DataReaderInterface reader = protocol.newReader(buffer.array(), buffer.readerIndex()); // create reader
            Object message = protocol.getDecoder().decode(reader); // decode message from reader
            buffer.readerIndex(reader.getOffset()); // set new index

            if (message != null) {
                Channels.fireMessageReceived(ctx, message);
            } else {
                break;
            }
        }
        buffer.discardReadBytes();
    }
}

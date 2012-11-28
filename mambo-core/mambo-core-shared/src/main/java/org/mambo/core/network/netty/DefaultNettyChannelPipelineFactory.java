package org.mambo.core.network.netty;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkProtocol;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 15:29
 */
public class DefaultNettyChannelPipelineFactory implements ChannelPipelineFactory {
    private final NetworkProtocol protocol;

    public DefaultNettyChannelPipelineFactory(@NotNull NetworkProtocol protocol) {
        this.protocol = checkNotNull(protocol);
    }

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();
        pipeline.addLast("protocol", new NettyProtocolAdapter(protocol));

        return pipeline;
    }
}

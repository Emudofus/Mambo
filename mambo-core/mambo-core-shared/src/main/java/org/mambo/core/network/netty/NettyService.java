package org.mambo.core.network.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.base.BaseNetworkService;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 14:49
 */
public abstract class NettyService<T extends NetworkClient> extends BaseNetworkService<T> {
    private final ServerBootstrap server;
    private final ChannelPipelineFactory pipelineFactory;
    private final int port;

    private Channel serverChannel;

    protected NettyService(int port, @NotNull ChannelPipelineFactory pipelineFactory, @NotNull NetworkHandlerManager<T> networkHandlerManager) {
        super(networkHandlerManager);
        this.port = port;
        this.pipelineFactory = pipelineFactory;

        server = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()
        ));
    }

    @NotNull
    protected abstract T newClient(@NotNull NettySession session);

    @Override
    protected void configure() {
        server.setPipelineFactory(pipelineFactory);
        server.setParentHandler(new Handler());

        server.setOption("localAddress", new InetSocketAddress(port));
        server.setOption("child.keepAlive", true);
        server.setOption("child.tcpNoDelay", true);
    }

    @Override
    protected void bind() throws Exception {
        serverChannel = server.bind();
    }

    @Override
    protected void unbind() throws Exception {
        serverChannel.unbind().awaitUninterruptibly();
        server.releaseExternalResources();
    }

    private final class Handler extends SimpleChannelHandler {
        public void childChannelOpen(ChannelHandlerContext ctx, ChildChannelStateEvent e) throws Exception {
            Channel channel = e.getChannel();

            NettySession session = new NettySession(channel);
            T client = newClient(session);

            addClient(client);
            channel.setAttachment(client);
        }
    }
}

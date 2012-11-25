package org.mambo.core.login.service.login;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.netty.NettyService;
import org.mambo.core.network.netty.NettySession;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:13
 */
public class NettyLoginService extends NettyService<LoginClient> implements LoginService {
    public static final int DEFAULT_PORT = 5555;

    @Inject
    private NettyLoginService(ConfigurationProvider config, ChannelPipelineFactory pipelineFactory, NetworkHandlerManager<LoginClient> networkHandlerManager) {
        super(config.getShort("login.port", DEFAULT_PORT), pipelineFactory, networkHandlerManager);
    }

    @NotNull
    @Override
    protected LoginClient newClient(@NotNull NettySession session) {
        return new DefaultLoginClient(this, session);
    }
}

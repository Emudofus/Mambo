package org.mambo.core.login.service.login;

import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.network.NetworkHandler;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkProtocol;
import org.mambo.core.network.base.ReflectiveNetworkHandlerManager;
import org.mambo.core.network.netty.DefaultNettyChannelPipelineFactory;
import org.mambo.protocol.client.DofusProtocol;
import org.mambo.protocol.client.MessageReceiver;

import javax.inject.Singleton;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:16
 */
public class NettyLoginServiceModule extends PrivateModule {
    private static final int INITIAL_CAPACITY = 512;

    @Override
    protected void configure() {
        bind(LoginService.class).to(NettyLoginService.class).in(Singleton.class);

        bind(MessageReceiver.class).toInstance(MessageReceiver.getInstance());

        expose(LoginService.class);
    }

    @Provides
    NetworkProtocol provideNetworkProtocol(MessageReceiver messageReceiver, ConfigurationProvider config) {
        return new DofusProtocol(messageReceiver, config.getInt("login.initial_capacity", INITIAL_CAPACITY));
    }

    @Singleton
    @Provides
    NetworkHandlerManager<LoginClient> provideNetworkHandlerManager(Set<NetworkHandler<LoginClient>> handlers) {
        return new ReflectiveNetworkHandlerManager<LoginClient>(handlers);
    }

    @Singleton
    @Provides
    ChannelPipelineFactory provideChannelPipelineFactory(NettyLoginService loginService) {
        return new DefaultNettyChannelPipelineFactory(loginService);
    }
}

package org.mambo.core.login.service.login;

import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.network.NetworkHandler;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkProtocol;
import org.mambo.core.network.base.ReflectiveNetworkHandlerManager;
import org.mambo.protocol.client.DofusProtocol;
import org.mambo.protocol.client.MessageReceiver;

import javax.inject.Singleton;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:23
 */
public class NioLoginServiceModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(LoginService.class).to(NioLoginService.class).in(Singleton.class);
        bind(MessageReceiver.class).toInstance(MessageReceiver.getInstance());

        expose(LoginService.class);
    }

    @Provides
    @Singleton
    NetworkProtocol provideNetworkProtocol(MessageReceiver messageReceiver, ConfigurationProvider config) {
        return new DofusProtocol(
                messageReceiver,
                config.getInt("services.login.nio.initial_capacity", NioLoginService.DEFAULT_INITIAL_CAPACITY)
        );
    }

    @Provides
    @Singleton
    NetworkHandlerManager<LoginClient> provideNetworkHandlerManager(Set<NetworkHandler<LoginClient>> handlers) {
        return new ReflectiveNetworkHandlerManager<LoginClient>(handlers);
    }
}

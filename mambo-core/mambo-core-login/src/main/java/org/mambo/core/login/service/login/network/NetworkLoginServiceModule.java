package org.mambo.core.login.service.login.network;

import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.network.NetworkHandler;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkProtocol;
import org.mambo.core.network.base.ReflectiveNetworkHandlerManager;
import org.mambo.protocol.client.DofusProtocol;
import org.mambo.protocol.client.MessageReceiver;
import org.mambo.protocol.client.ProtocolTypeManager;

import javax.inject.Singleton;
import java.util.Set;

/**
 * @author Blackrush
 */
public class NetworkLoginServiceModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(LoginService.class).to(NioLoginService.class).in(Scopes.SINGLETON);
        bind(MessageReceiver.class).toInstance(MessageReceiver.getInstance());
        bind(ProtocolTypeManager.class).toInstance(ProtocolTypeManager.getInstance());

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

package org.mambo.core.login.service.login;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkProtocol;
import org.mambo.core.network.NetworkSession;
import org.mambo.core.network.nio.NioService;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:20
 */
public class NioLoginService extends NioService<LoginClient> implements LoginService {

    public static final int DEFAULT_PORT = 5555;
    public static final int DEFAULT_INITIAL_CAPACITY = 1024;

    @Inject
    public NioLoginService(ConfigurationProvider config, NetworkProtocol protocol, NetworkHandlerManager<LoginClient> handlerManager) {
        super(
                LoggerFactory.getLogger(NioLoginService.class), // Guice does not support slf4j's logger injection
                config.getInt("services.login.port", DEFAULT_PORT),
                config.getInt("services.login.nio.initial_capacity", DEFAULT_INITIAL_CAPACITY),
                protocol,
                handlerManager
        );
    }

    @NotNull
    @Override
    protected LoginClient newClient(@NotNull NetworkSession session) {
        return new DefaultLoginClient(this, session);
    }
}

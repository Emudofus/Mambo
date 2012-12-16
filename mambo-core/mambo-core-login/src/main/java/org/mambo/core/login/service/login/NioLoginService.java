package org.mambo.core.login.service.login;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkProtocol;
import org.mambo.core.network.NetworkSession;
import org.mambo.core.network.nio.NioService;
import org.mambo.protocol.client.MessageReceiver;
import org.mambo.protocol.client.ProtocolTypeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:20
 */
public class NioLoginService extends NioService<LoginClient> implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(NioLoginService.class);

    public static final int DEFAULT_PORT = 5555;
    public static final int DEFAULT_INITIAL_CAPACITY = 1024;

    @Inject
    private ProtocolTypeManager protocolTypeManager;

    @Inject
    private MessageReceiver messageReceiver;

    @Inject
    public NioLoginService(ConfigurationProvider config, NetworkProtocol protocol, NetworkHandlerManager<LoginClient> handlerManager) {
        super(
                log, // Guice does not support slf4j's logger injection
                config.getInt("services.login.port", DEFAULT_PORT),
                config.getInt("services.login.nio.initial_capacity", DEFAULT_INITIAL_CAPACITY),
                protocol,
                handlerManager
        );
    }

    @Override
    protected void startUp() throws Exception {
        super.startUp();

        log.debug("{} types loaded", protocolTypeManager.load());
        log.debug("{} messages loaded", messageReceiver.load());

        log.info("started");
    }

    @Override
    protected void shutDown() throws Exception {
        super.shutDown();

        log.info("stopped");
    }

    @NotNull
    @Override
    protected LoginClient newClient(@NotNull NetworkSession session) {
        return new DefaultLoginClient(this, session);
    }
}

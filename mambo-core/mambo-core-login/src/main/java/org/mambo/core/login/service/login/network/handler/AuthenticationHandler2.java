package org.mambo.core.login.service.login.network.handler;

import org.mambo.core.configuration.InjectConfig;
import org.mambo.core.event.Event;
import org.mambo.core.event.EventHandler;
import org.mambo.core.login.database.model.User;
import org.mambo.core.login.service.login.crypto.AuthenticationException;
import org.mambo.core.login.service.login.crypto.LoginCryptoService;
import org.mambo.core.login.service.login.network.LoginClient;
import org.mambo.core.network.base.event.NetworkClientConnectionEvent;
import org.mambo.core.network.base.event.NetworkClientDisconnectionEvent;
import org.mambo.core.network.base.event.NetworkClientMessageEvent;
import org.mambo.protocol.client.messages.*;
import org.mambo.shared.database.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * just an example of what can be done with EventBusNetworkHandlerManager
 * it's not yet ready-to-use and must be improved
 *
 * @author Blackrush
 *         Mambo
 */
public class AuthenticationHandler2 {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationHandler2.class);

    @InjectConfig("services.login.required_version") int requiredVersion;
    @InjectConfig("services.login.current_version") int currentVersion;
    @InjectConfig("services.community") int communityId;
    @Inject Repository<User> users;
    @Inject LoginCryptoService crypto;

    @EventHandler
    public void onIdentificationmessage(Event<NetworkClientMessageEvent<LoginClient>> event) {
        if (!(event.get().getMessage() instanceof IdentificationMessage)) return;
        LoginClient client = event.get().getClient();
        IdentificationMessage msg = (IdentificationMessage) event.get().getMessage();

        try {
            User user = crypto.authenticate(msg.credentials);

            event.reply(new IdentificationSuccessMessage(
                    user.hasRights(),
                    false,
                    user.getUsername(),
                    user.getNickname(),
                    user.getId().intValue(),
                    (byte) communityId,
                    user.getSecretQuestion(),
                    user.getSubscriptionEnd() != null ? user.getSubscriptionEnd().getMillis() : 0.0,
                    user.getCreatedAt().getMillis()
            ));
        } catch (AuthenticationException e) {
            log.debug("{} failed to authenticate because : {}", client.getSession().getRemoteAddress(), e.getMessage());
            event.reply(new IdentificationFailedMessage((byte) e.getReason().value()));
        } catch (Throwable t) {
            log.error(String.format("can't authenticate %s", client.getSession().getRemoteAddress()), t);
            client.getSession().close();
        }
    }

    @EventHandler
    public void onConnected(Event<NetworkClientConnectionEvent<LoginClient>> event) {
        LoginClient client = event.get().getClient();
        event.reply(new ProtocolRequired(requiredVersion, currentVersion));
        event.reply(new HelloConnectMessage(client.getTicket(), crypto.getPublicKey().getEncoded()));
    }

    @EventHandler
    public void onDisconnected(NetworkClientDisconnectionEvent<LoginClient> event) {
        // just an example
    }
}

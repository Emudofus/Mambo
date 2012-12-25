package org.mambo.core.login.service.login.network.handler;

import org.mambo.core.configuration.InjectConfig;
import org.mambo.core.event.EventHandler;
import org.mambo.core.event.Event;
import org.mambo.core.login.database.model.User;
import org.mambo.core.login.service.login.crypto.BadCredentialsException;
import org.mambo.core.login.service.login.crypto.LoginCryptoService;
import org.mambo.core.login.service.login.network.LoginClient;
import org.mambo.core.network.base.event.NetworkClientConnectionEvent;
import org.mambo.core.network.base.event.NetworkClientDisconnectionEvent;
import org.mambo.core.network.base.event.NetworkClientMessageEvent;
import org.mambo.protocol.client.enums.IdentificationFailureReasonEnum;
import org.mambo.protocol.client.messages.HelloConnectMessage;
import org.mambo.protocol.client.messages.IdentificationFailedMessage;
import org.mambo.protocol.client.messages.IdentificationMessage;
import org.mambo.protocol.client.messages.ProtocolRequired;
import org.mambo.shared.database.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * @author Blackrush
 *         Mambo
 */
public class AuthenticationHandler2 {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationHandler2.class);

    public static final byte WRONG_CREDENTIALS = (byte) IdentificationFailureReasonEnum.WRONG_CREDENTIALS.value();

    @InjectConfig("services.login.required_version") int requiredVersion;
    @InjectConfig("services.login.current_version") int currentVersion;
    @Inject Repository<User> users;
    @Inject LoginCryptoService crypto;

    @EventHandler
    public void onIdentificationmessage(Event<NetworkClientMessageEvent<LoginClient>> event) {
        if (!(event.get().getMessage() instanceof IdentificationMessage)) return;
        IdentificationMessage msg = (IdentificationMessage) event.get().getMessage();

        try {
            User user = crypto.find(msg.credentials);
            // TODO do other stuff with found user
        } catch (BadCredentialsException e) {
            event.reply(new IdentificationFailedMessage(WRONG_CREDENTIALS));
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

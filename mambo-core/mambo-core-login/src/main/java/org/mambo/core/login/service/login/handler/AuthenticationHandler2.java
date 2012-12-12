package org.mambo.core.login.service.login.handler;

import org.mambo.core.configuration.InjectConfig;
import org.mambo.core.event.EventHandler;
import org.mambo.core.event.EventInterface;
import org.mambo.core.login.database.model.User;
import org.mambo.core.login.service.login.LoginClient;
import org.mambo.core.network.base.event.NetworkClientConnectionEvent;
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

    public static final byte IN_MAINTENANCE = (byte) IdentificationFailureReasonEnum.IN_MAINTENANCE.value();

    @InjectConfig("login.required_version") int requiredVersion;
    @InjectConfig("login.current_version") int currentVersion;
    @Inject Repository<User> users;

    @EventHandler
    public void onIdentificationmessage(EventInterface<NetworkClientMessageEvent<LoginClient>> event) {
        if (!(event.get().getMessage() instanceof IdentificationMessage)) return;
        IdentificationMessage message = (IdentificationMessage) event.get().getMessage();

        User user = users.find("username", message.login);
        event.reply(new IdentificationFailedMessage(IN_MAINTENANCE));

        log.debug("{} tried to connect", user.getNickname());
    }

    @EventHandler
    public void onConnected(EventInterface<NetworkClientConnectionEvent<LoginClient>> event) {
        LoginClient client = event.get().getClient();
        event.reply(new ProtocolRequired(requiredVersion, currentVersion));
        event.reply(new HelloConnectMessage(client.getTicket(), new byte[0])); // TODO get rsa public key from LoginService
    }
}

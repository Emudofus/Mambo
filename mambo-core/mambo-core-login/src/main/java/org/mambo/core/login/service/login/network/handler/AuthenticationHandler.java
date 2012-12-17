package org.mambo.core.login.service.login.network.handler;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.InjectConfig;
import org.mambo.core.login.database.model.User;
import org.mambo.core.login.service.login.crypto.LoginCryptoService;
import org.mambo.core.login.service.login.network.LoginClient;
import org.mambo.core.network.NetworkSession;
import org.mambo.core.network.base.BaseNetworkHandler;
import org.mambo.protocol.client.enums.IdentificationFailureReasonEnum;
import org.mambo.protocol.client.messages.*;
import org.mambo.shared.database.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:21
 */
public class AuthenticationHandler extends BaseNetworkHandler<LoginClient> {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationHandler.class);

    public static final byte WRONG_CREDENTIALS = (byte) IdentificationFailureReasonEnum.WRONG_CREDENTIALS.value();
    public static final byte IN_MAINTENANCE = (byte) IdentificationFailureReasonEnum.IN_MAINTENANCE.value();

    @InjectConfig("services.login.required_version") int requiredVersion;
    @InjectConfig("services.login.current_version") int currentVersion;
    @Inject Repository<User> users;
    @Inject LoginCryptoService crypto;

    private static String getUsername(IdentificationMessage message) {
        return "foo"; // TODO read message.credentials
    }

    @Handler
    public void identificationAction(LoginClient client, final IdentificationMessage msg) {
        try {
            User user = crypto.find(msg.credentials);
            client.getSession().close();
        } catch (Throwable t) {
            client.getSession().write(new IdentificationFailedMessage(WRONG_CREDENTIALS));
        }
    }

    @Override
    public void connected(@NotNull LoginClient client) {
        NetworkSession session = client.getSession();
        session.write(new ProtocolRequired(requiredVersion, currentVersion));
        session.write(new HelloConnectMessage(client.getTicket(), crypto.getPublicKey().getEncoded()));
    }
}

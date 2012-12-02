package org.mambo.core.login.service.login.handler;

import com.google.common.util.concurrent.MoreExecutors;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.InjectConfig;
import org.mambo.core.login.service.login.LoginClient;
import org.mambo.core.network.NetworkSession;
import org.mambo.core.network.base.BaseNetworkHandler;
import org.mambo.protocol.client.enums.IdentificationFailureReasonEnum;
import org.mambo.protocol.client.messages.HelloConnectMessage;
import org.mambo.protocol.client.messages.IdentificationFailedMessage;
import org.mambo.protocol.client.messages.IdentificationMessage;
import org.mambo.protocol.client.messages.ProtocolRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:21
 */
public class AuthenticationHandler extends BaseNetworkHandler<LoginClient> {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationHandler.class);

    public static final byte IN_MAINTENANCE = (byte) IdentificationFailureReasonEnum.IN_MAINTENANCE.value();

    @InjectConfig("login.required_version") int requiredVersion;
    @InjectConfig("login.current_version") int currentVersion;

    @Handler
    public void identificationAction(LoginClient client, final IdentificationMessage msg) {
        client.getSession().write(new IdentificationFailedMessage(IN_MAINTENANCE)).addListener(new Runnable() {
            public void run() {
                log.debug("{} tried to connect", msg.login);
            }
        }, MoreExecutors.sameThreadExecutor());
    }

    @Override
    public void connected(@NotNull LoginClient client) {
        NetworkSession session = client.getSession();
        session.write(new ProtocolRequired(requiredVersion, currentVersion));
        session.write(new HelloConnectMessage(client.getTicket(), new byte[0])); // TODO get rsa public key from LoginService
    }
}

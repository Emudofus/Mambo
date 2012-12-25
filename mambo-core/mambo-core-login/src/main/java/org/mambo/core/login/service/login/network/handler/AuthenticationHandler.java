package org.mambo.core.login.service.login.network.handler;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.InjectConfig;
import org.mambo.core.login.database.model.User;
import org.mambo.core.login.service.login.crypto.AuthenticationException;
import org.mambo.core.login.service.login.crypto.LoginCryptoService;
import org.mambo.core.login.service.login.network.LoginClient;
import org.mambo.core.network.NetworkSession;
import org.mambo.core.network.base.BaseNetworkHandler;
import org.mambo.protocol.client.messages.*;
import org.mambo.shared.database.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * @author Blackrush
 * @see AuthenticationHandler2 {@link org.mambo.core.network.base.EventBusNetworkHandlerManager} alternative
 */
public class AuthenticationHandler extends BaseNetworkHandler<LoginClient> {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationHandler.class);

    @InjectConfig("services.login.required_version") int requiredVersion;
    @InjectConfig("services.login.current_version") int currentVersion;
    @InjectConfig("services.community") int communityId;
    @Inject Repository<User> users;
    @Inject LoginCryptoService crypto;

    @Handler
    public void identificationAction(LoginClient client, IdentificationMessage msg) {
        try {
            User user = crypto.authenticate(msg.credentials);

            client.getSession().write(new IdentificationSuccessMessage(
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
            client.getSession().write(new IdentificationFailedMessage((byte) e.getReason().value()));
        } catch (Throwable t) {
            log.error(String.format("can't authenticate %s", client.getSession().getRemoteAddress()), t);
            client.getSession().close();
        }
    }

    @Override
    public void connected(@NotNull LoginClient client) {
        NetworkSession session = client.getSession();
        session.write(new ProtocolRequired(requiredVersion, currentVersion));
        session.write(new HelloConnectMessage(client.getTicket(), crypto.getPublicKey().getEncoded()));
    }
}

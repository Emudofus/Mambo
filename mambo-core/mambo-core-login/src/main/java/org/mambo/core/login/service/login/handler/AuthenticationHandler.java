package org.mambo.core.login.service.login.handler;

import com.google.common.util.concurrent.MoreExecutors;
import org.mambo.core.login.service.login.LoginClient;
import org.mambo.core.network.base.BaseNetworkHandler;
import org.mambo.protocol.client.enums.IdentificationFailureReasonEnum;
import org.mambo.protocol.client.messages.IdentificationFailedMessage;
import org.mambo.protocol.client.messages.IdentificationMessage;
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
    public static final byte REASON = (byte) IdentificationFailureReasonEnum.IN_MAINTENANCE.value();

    @Handler
    public void identificationAction(LoginClient client, final IdentificationMessage msg) {
        client.getSession().write(new IdentificationFailedMessage(REASON)).addListener(new Runnable() {
            public void run() {
                log.debug("{} tried to connect", msg.login);
            }
        }, MoreExecutors.sameThreadExecutor());
    }
}

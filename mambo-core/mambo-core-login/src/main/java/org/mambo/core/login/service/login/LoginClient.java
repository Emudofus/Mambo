package org.mambo.core.login.service.login;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:10
 */
public interface LoginClient extends NetworkClient {
    @NotNull
    @Override
    LoginService getService();

    @NotNull
    String getTicket();
}

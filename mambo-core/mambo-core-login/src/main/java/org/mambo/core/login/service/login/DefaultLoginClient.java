package org.mambo.core.login.service.login;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkSession;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:11
 */
public class DefaultLoginClient implements LoginClient {
    private final LoginService service;
    private final NetworkSession session;

    public DefaultLoginClient(@NotNull LoginService service, @NotNull NetworkSession session) {
        this.service = checkNotNull(service);
        this.session = checkNotNull(session);
    }

    @NotNull
    @Override
    public LoginService getService() {
        return service;
    }

    @NotNull
    @Override
    public NetworkSession getSession() {
        return session;
    }
}

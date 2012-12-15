package org.mambo.core.login.service.login;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkSession;
import org.mambo.core.rand.RandomString;

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
    private final String ticket;

    public DefaultLoginClient(@NotNull LoginService service, @NotNull NetworkSession session) {
        this.service = checkNotNull(service);
        this.session = checkNotNull(session);
        this.ticket = RandomString.generate(32);
    }

    @NotNull
    @Override
    public LoginService getService() {
        return service;
    }

    @NotNull
    @Override
    public String getTicket() {
        return ticket;
    }

    @NotNull
    @Override
    public NetworkSession getSession() {
        return session;
    }
}

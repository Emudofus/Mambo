package org.mambo.core.login.service.login;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.mambo.core.login.service.login.crypto.DefaultLoginCryptoService;
import org.mambo.core.login.service.login.crypto.LoginCryptoService;
import org.mambo.core.login.service.login.network.NetworkLoginServiceModule;
import org.mambo.core.login.service.login.network.handler.NetworkLoginServiceHandlerModule;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/12/12
 * Time: 21:08
 */
public class LoginServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new NetworkLoginServiceModule());
        install(new NetworkLoginServiceHandlerModule());

        bind(LoginCryptoService.class).to(DefaultLoginCryptoService.class).in(Scopes.SINGLETON);
    }
}

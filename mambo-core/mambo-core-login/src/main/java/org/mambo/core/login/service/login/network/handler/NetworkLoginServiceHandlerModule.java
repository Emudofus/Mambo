package org.mambo.core.login.service.login.network.handler;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import org.mambo.core.login.service.login.network.LoginClient;
import org.mambo.core.network.NetworkHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:20
 */
public class NetworkLoginServiceHandlerModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<NetworkHandler<LoginClient>> handlers = Multibinder.newSetBinder(binder(), new TypeLiteral<NetworkHandler<LoginClient>>(){});

        handlers.addBinding().to(AuthenticationHandler.class).in(Scopes.SINGLETON);
    }
}

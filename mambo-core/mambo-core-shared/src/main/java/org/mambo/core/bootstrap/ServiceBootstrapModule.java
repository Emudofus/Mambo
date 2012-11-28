package org.mambo.core.bootstrap;

import com.google.common.util.concurrent.Service;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.mambo.core.inject.Matchers2;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 28/11/12
 * Time: 18:45
 */
public class ServiceBootstrapModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ServiceBootstrap.class).in(Singleton.class);

        final Provider<ServiceBootstrap> provider = getProvider(ServiceBootstrap.class);

        bindListener(Matchers2.subclassesOf(Service.class), new TypeListener() {
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                encounter.register(new InjectionListener<I>() {
                    public void afterInjection(I injectee) {
                        provider.get().register((Service) injectee);
                    }
                });
            }
        });
    }
}

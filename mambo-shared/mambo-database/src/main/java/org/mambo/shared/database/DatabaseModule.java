package org.mambo.shared.database;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import fi.evident.dalesbred.Database;
import fi.evident.dalesbred.instantiation.InstantiationListener;
import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:26
 */
public abstract class DatabaseModule extends AbstractModule {
    protected abstract void configureRepositories();

    @Override
    protected void configure() {
        final Provider<Injector> injector = getProvider(Injector.class);

        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                if (Database.class.isAssignableFrom(type.getRawType())) {
                    encounter.register(new InjectionListener<I>() {
                        public void afterInjection(I injectee) {
                            Database db = (Database) injectee;
                            final Injector inject = injector.get();
                            db.getInstantiatorRegistry().addInstantiationListener(new InstantiationListener() {
                                public void onInstantiation(@NotNull Object object) {
                                    inject.injectMembers(object);
                                }
                            });
                        }
                    });
                }
            }
        });

        configureRepositories();
    }

    protected <E extends EntityInterface<?>, R extends Repository<E>> void bindRepository(TypeLiteral<R> repository) {
        bind(new TypeLiteral<Repository<E>>(){}).to(repository).in(Singleton.class);
    }
}

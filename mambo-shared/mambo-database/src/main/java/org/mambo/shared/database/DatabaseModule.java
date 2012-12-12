package org.mambo.shared.database;

import com.google.inject.*;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.mambo.core.inject.Matchers2;
import org.mambo.shared.database.impl.SimpleMutableRepository;
import org.mambo.shared.database.persistence.PersistenceStrategy;

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
        try {
            configureRepositories();

            bindListener(Matchers2.subclassesOf(Repository.class), new RepositoryListener());
        } catch (Throwable t) {
            addError(t);
        }
    }

    @Provides
    @Singleton
    DatabaseContext provideDatabaseContext(PersistenceStrategy persistenceStrategy) {
        return new DatabaseContext(persistenceStrategy);
    }

    protected <E extends Entity> void bindRepository(Class<E> clazz) {
        // TODO
    }

    protected <E extends MutableEntity> void bindMutableRepository(Class<E> clazz) {
        bind(new TypeLiteral<MutableRepository<E>>(){})
            .toProvider(new MutableRepositoryProvider<E>(clazz))
                .in(Scopes.SINGLETON);
    }

    private class MutableRepositoryProvider<E extends MutableEntity> implements Provider<MutableRepository<E>> {
        private final Class<E> clazz;
        private final Provider<DatabaseContext> ctx = getProvider(DatabaseContext.class);

        private MutableRepositoryProvider(Class<E> clazz) {
            this.clazz = clazz;
        }

        @Override
        public MutableRepository<E> get() {
            return new SimpleMutableRepository<E>(ctx.get(), clazz);
        }
    }

    private class RepositoryListener implements TypeListener {
        @Override
        public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
            if (!Repository.class.isAssignableFrom(type.getRawType())) return;

            encounter.register(new InjectionListener<I>() {
                public void afterInjection(I injectee) {
                    DatabaseContext ctx = getProvider(DatabaseContext.class).get();
                    ctx.register((Repository<?>) injectee);
                }
            });
        }
    }
}

package org.mambo.shared.database;

import com.google.inject.*;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.google.inject.util.Types;
import org.mambo.core.inject.Matchers2;
import org.mambo.shared.database.impl.SimpleMutableRepository;
import org.mambo.shared.database.impl.SimpleRepository;
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
        bind(getRepositoryTypeLiteral(clazz)).toProvider(new RepositoryProvider<E>(clazz));
    }

    protected <E extends MutableEntity> void bindMutableRepository(Class<E> clazz) {
        MutableRepositoryProvider<E> provider = new MutableRepositoryProvider<E>(clazz);
        bind(getRepositoryTypeLiteral(clazz)).toProvider(provider);
        bind(getMutableRepositoryTypeLiteral(clazz)).toProvider(provider);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Entity> TypeLiteral<Repository<E>> getRepositoryTypeLiteral(Class<E> clazz) {
        return (TypeLiteral<Repository<E>>) TypeLiteral.get(Types.newParameterizedType(
                Repository.class,
                TypeLiteral.get(clazz).getType()
        ));
    }

    @SuppressWarnings("unchecked")
    private static <E extends MutableEntity> TypeLiteral<MutableRepository<E>> getMutableRepositoryTypeLiteral(Class<E> clazz) {
        return (TypeLiteral<MutableRepository<E>>) TypeLiteral.get(Types.newParameterizedType(
                MutableRepository.class,
                TypeLiteral.get(clazz).getType()
        ));
    }

    private class RepositoryProvider<E extends Entity> implements Provider<Repository<E>> {
        private final Class<E> clazz;
        private final Provider<DatabaseContext> ctx = getProvider(DatabaseContext.class);

        private Repository<E> repository;

        private RepositoryProvider(Class<E> clazz) {
            this.clazz = clazz;
        }

        @Override
        public Repository<E> get() {
            if (repository == null) {
                repository = new SimpleRepository<E>(ctx.get(), clazz);
            }
            return repository;
        }
    }

    private class MutableRepositoryProvider<E extends MutableEntity> implements Provider<MutableRepository<E>> {
        private final Class<E> clazz;
        private final Provider<DatabaseContext> ctx = getProvider(DatabaseContext.class);

        private MutableRepository<E> repository;

        private MutableRepositoryProvider(Class<E> clazz) {
            this.clazz = clazz;
        }

        @Override
        public MutableRepository<E> get() {
            if (repository == null) {
                repository = new SimpleMutableRepository<E>(ctx.get(), clazz);
            }
            return repository;
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

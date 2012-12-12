package org.mambo.shared.database;

import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.persistence.PersistenceStrategy;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 17:42
 */
public class DatabaseContext {
    private final Map<Class<?>, Repository<?>> repositories =
            Maps.newHashMap();

    private final PersistenceStrategy persistenceStrategy;

    public DatabaseContext(@NotNull PersistenceStrategy persistenceStrategy) {
        this.persistenceStrategy = checkNotNull(persistenceStrategy);
    }

    @NotNull
    public PersistenceStrategy getPersistenceStrategy() {
        return persistenceStrategy;
    }

    public <T extends Repository<?>> T register(T repository) {
        Class<?> entityClass = repository.getEntityMetadata().getEntityClass();

        if (repositories.containsKey(entityClass)) {
            throw new UnsupportedOperationException("this database context already contains a " + entityClass.getName() + " repository");
        }

        repositories.put(entityClass, repository);
        return repository;
    }

    @SuppressWarnings("unchecked")
    public <E extends Entity> Repository<E> get(Class<E> entityClass) {
        return (Repository<E>) repositories.get(entityClass);
    }

    @SuppressWarnings("unchecked")
    public <E extends MutableEntity> MutableRepository<E> getMutable(Class<E> entityClass) {
        return (MutableRepository<E>) repositories.get(entityClass);
    }
}

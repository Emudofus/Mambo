package org.mambo.shared.database;

import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.impl.SimpleMutableRepository;
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
            Maps.newIdentityHashMap();

    private final PersistenceStrategy persistenceStrategy;

    public DatabaseContext(@NotNull PersistenceStrategy persistenceStrategy) {
        this.persistenceStrategy = checkNotNull(persistenceStrategy);
    }

    @NotNull
    public PersistenceStrategy getPersistenceStrategy() {
        return persistenceStrategy;
    }

    public void register(Repository<?> repository) {
        if (repositories.containsKey(repository.getClass())) {
            throw new UnsupportedOperationException("");
        }
        repositories.put(repository.getClass(), repository);
    }

    public <E extends Entity> void registerEntity(Class<E> clazz) {
        // TODO
    }

    public <E extends Entity> Repository<E> getEntity(Class<E> clazz) {
        return null; // TODO
    }

    public <E extends MutableEntity> void registerModel(Class<E> clazz) {
        repositories.put(clazz, new SimpleMutableRepository<E>(this, clazz));
    }

    @SuppressWarnings("unchecked")
    public <E extends MutableEntity> MutableRepository<E> getModel(Class<E> clazz) {
        return (MutableRepository<E>) repositories.get(clazz);
    }
}

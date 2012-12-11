package org.mambo.shared.database;

import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.impl.SimpleModelRepository;

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

    public <E extends EntityInterface<?>> void registerEntity(Class<E> clazz) {
        // TODO
    }

    public <E extends EntityInterface<?>> Repository<E> getEntity(Class<E> clazz) {
        return null; // TODO
    }

    public <E extends ModelInterface<?>> void registerModel(Class<E> clazz) {
        repositories.put(clazz, new SimpleModelRepository<E>(this, clazz));
    }

    @SuppressWarnings("unchecked")
    public <E extends ModelInterface<?>> ModelRepository<E> getModel(Class<E> clazz) {
        return (ModelRepository<E>) repositories.get(clazz);
    }
}

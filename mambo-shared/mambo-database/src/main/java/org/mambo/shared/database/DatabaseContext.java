package org.mambo.shared.database;

import com.google.common.collect.Maps;
import org.mambo.shared.database.impl.SimpleModelRepository;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 17:42
 */
public class DatabaseContext {
    private final Map<Class<? extends EntityInterface<?>>, Repository<?>> repositories =
            Maps.newIdentityHashMap();

    public <E extends EntityInterface<?>> void registerEntity(Class<E> clazz) {
        // TODO
    }

    public <E extends EntityInterface<?>> Repository<E> getEntity(Class<E> clazz) {
        return null; // TODO
    }

    public <E extends ModelInterface<?>> void registerModel(Class<E> clazz) {
        repositories.put(clazz, new SimpleModelRepository<E>(clazz, persistence));
    }

    @SuppressWarnings("unchecked")
    public <E extends ModelInterface<?>> ModelRepository<E> getModel(Class<E> clazz) {
        return (ModelRepository<E>) repositories.get(clazz);
    }
}

package org.mambo.shared.database.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ModelInterface;
import org.mambo.shared.database.ModelRepository;
import org.mambo.shared.database.impl.internal.EntityField;
import org.mambo.shared.database.impl.internal.EntityMetadata;
import org.mambo.shared.database.impl.internal.References;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * a thread-safe and very simple {@link ModelRepository}
 * todo: database management
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 15:53
 */
public class SimpleModelRepository<E extends ModelInterface<?>> implements ModelRepository<E> {
    private final EntityMetadata metadata;
    private final Map<Object, E> entities = Maps.newHashMap();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public SimpleModelRepository(@NotNull Class<E> clazz) {
        this.metadata = EntityMetadata.of(clazz);
    }

    protected boolean isPersisted(@NotNull Object id) {
        lock.readLock().lock();
        try {
            return entities.containsKey(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean isPersisted(@NotNull E entity) {
        return isPersisted(entity.getId());
    }

    @Override
    public void persist(@NotNull E entity) {
        if (!isPersisted(entity)) {
            // TODO insert entity in database

            lock.writeLock().lock();
            try {
                entities.put(entity.getId(), entity);
            } finally {
                lock.writeLock().unlock();
            }
        } else {
            // TODO update entity in database
        }
    }

    @Override
    public void delete(@NotNull E entity) {
        delete(entity.getId());
    }

    @NotNull
    @Override
    public E delete(@NotNull Object id) {
        if (!isPersisted(id)) {
            throw new IllegalArgumentException("unknown id=" + id);
        }

        E entity;
        lock.writeLock().lock();
        try {
            entity = entities.remove(id);
        } finally {
            lock.writeLock().unlock();
        }

        // TODO delete entity in database

        return entity;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public E createEmpty() {
        return (E) metadata.createEmpty();
    }

    @NotNull
    @Override
    public E createWithValues(Function<E, Void> initializer) {
        E entity = createEmpty();
        initializer.apply(entity);
        return entity;
    }

    @Override
    public E find(Object id) {
        lock.readLock().lock();
        try {
            return entities.get(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E find(String property, Object value) {
        EntityField field = metadata.getField(property);
        if (field == null) {
            throw new IllegalArgumentException("unknown property \"" + property + "\"");
        }

        lock.readLock().lock();
        try {
            for (E entity : entities.values()) {
                Object fieldValue = field.get(entity);
                if (fieldValue == value) {
                    return entity;
                }
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<E> findAll(String property, Object value) {
        EntityField field = metadata.getField(property);
        if (field == null) {
            throw new IllegalArgumentException("unknown property \"" + property + "\"");
        }

        lock.readLock().lock();
        try {
            List<E> result = Lists.newArrayList();
            for (E entity : entities.values()) {
                Object fieldValue = field.get(entity);
                if (fieldValue == value) {
                    result.add(entity);
                }
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E getReference(Object id) {
        return References.create(this, metadata, id);
    }
}

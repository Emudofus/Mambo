package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:54
 */
public interface Repository<E extends EntityInterface<?>> {
    /**
     * returns a persisted entity by its id
     * @param id persisted entity's id
     * @return persisted  entity
     */
    E find(@NotNull Object id);

    /**
     * returns a persisted entity by one of its properties
     * @param property property name
     * @param value property value
     * @return persisted entity
     */
    E find(@NotNull String property, Object value);

    /**
     * returns a list of persisted entity by one of their properties
     * @param property property name
     * @param value property value
     * @return list of persisted entity
     */
    List<E> findAll(@NotNull String property, Object value);

    /**
     * returns a lazy reference to an entity by its id
     * @param id entity's id
     * @return lazy reference
     */
    E getReference(@NotNull Object id);
}

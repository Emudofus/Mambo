package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.impl.internal.EntityMetadata;

import java.util.List;

/**
 * only provides search methods
 * can handle {@link Entity} and {@link MutableEntity}
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:54
 */
public interface Repository<E extends Entity> {
    /**
     * returns entity's metadata
     * @return non-null {@link EntityMetadata}
     */
    @NotNull
    EntityMetadata getEntityMetadata();

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

package org.mambo.shared.database;

import com.google.common.base.Function;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 20:01
 */
public interface MutableRepository<E extends MutableEntity> extends Repository<E> {
    /**
     * @param entity non-null entity
     * @return true if exists in database
     */
    boolean isPersisted(@NotNull E entity);

    /**
     * insert or update entity
     * @param entity non-null entity to persist
     */
    void persist(@NotNull E entity);

    /**
     * delete entity
     * @param entity non-null entity to delete
     */
    void delete(@NotNull E entity);

    /**
     * delete entity by its id
     * @param id non-null entity's id
     * @return non-null entity deleted
     */
    @NotNull
    E delete(@NotNull Object id);

    /**
     * @return non-null empty entity
     */
    @NotNull
    E createEmpty();

    /**
     * @param initializer initialize created entity
     * @return non-null initialized entity
     */
    @NotNull
    E createWithValues(Function<E, Void> initializer);
}

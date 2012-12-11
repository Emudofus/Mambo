package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

/**
 * represents a mutable entity
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 20:01
 */
public interface MutableEntity extends Entity {
    void setId(@NotNull Object id);

    /**
     * @return true if exists in database
     */
    boolean isPersisted();

    /**
     * insert or update entity
     */
    void persist();

    /**
     * delete entity
     */
    void delete();
}

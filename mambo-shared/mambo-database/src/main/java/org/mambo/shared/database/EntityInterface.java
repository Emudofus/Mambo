package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:54
 */
public interface EntityInterface<K> {
    /**
     * @return entity's unique id
     */
    @NotNull
    K getId();

    /**
     * @param id entity's unique id
     */
    void setId(@NotNull K id);
}

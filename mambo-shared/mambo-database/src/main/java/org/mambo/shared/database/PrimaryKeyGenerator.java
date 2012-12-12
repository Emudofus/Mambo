package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:14
 */
public interface PrimaryKeyGenerator<K> {
    /**
     * initilialize this generator with existing entities
     * @param entities existing entities
     */
    void initialize(@NotNull Iterable<? extends Entity> entities);

    /**
     * generate an unique primary key
     * @return unique primary key
     */
    @NotNull
    K next();
}

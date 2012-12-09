package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:14
 */
public interface PrimaryKeyGenerator<K> {
    /**
     * initilialize this generator with existing keys
     * @param keys existing keys
     */
    void initialize(@NotNull Collection<K> keys);

    /**
     * generate an unique primary key
     * @return unique primary key
     */
    @NotNull
    K next();
}

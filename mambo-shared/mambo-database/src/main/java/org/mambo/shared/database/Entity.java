package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

/**
 * represents an immutable entity
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:54
 */
public interface Entity {
    /**
     * @return entity's unique id
     */
    @NotNull
    Object getId();
}

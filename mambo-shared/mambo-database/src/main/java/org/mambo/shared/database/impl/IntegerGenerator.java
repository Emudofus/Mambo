package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.PrimaryKeyGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:17
 */
public class IntegerGenerator implements PrimaryKeyGenerator<Integer> {
    private Integer next = 0;

    @Override
    public void initialize(@NotNull Iterable<? extends Entity> entities) {
        for (Entity entity : entities) {
            if (!(entity.getId() instanceof Integer)) {
                throw new IllegalArgumentException("entities must have an Integer id");
            }

            Integer id = (Integer) entity.getId();
            if (next < id) {
                next = id;
            }
        }
    }

    @NotNull
    @Override
    public Integer next() {
        return ++next;
    }
}

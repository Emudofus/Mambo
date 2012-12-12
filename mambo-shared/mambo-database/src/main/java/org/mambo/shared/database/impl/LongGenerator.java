package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.PrimaryKeyGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:19
 */
public class LongGenerator implements PrimaryKeyGenerator<Long> {
    private Long next = 0L;

    @Override
    public void initialize(@NotNull Iterable<? extends Entity> entities) {
        for (Entity entity : entities) {
            if (!(entity.getId() instanceof Long)) {
                throw new IllegalArgumentException("entities must have a Long id");
            }

            Long id = (Long) entity.getId();
            if (next < id) {
                next = id;
            }
        }
    }

    @NotNull
    @Override
    public Long next() {
        return ++next;
    }
}

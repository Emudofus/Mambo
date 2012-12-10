package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.PrimaryKeyGenerator;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:19
 */
public class LongGenerator implements PrimaryKeyGenerator<Long> {
    private Long next = 0L;

    @Override
    public void initialize(@NotNull Collection<Long> keys) {
        for (Long key : keys) {
            if (next < key) {
                next = key;
            }
        }
    }

    @NotNull
    @Override
    public Long next() {
        return ++next;
    }
}

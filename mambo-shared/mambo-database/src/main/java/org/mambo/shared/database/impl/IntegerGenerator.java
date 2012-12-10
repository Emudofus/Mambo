package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.PrimaryKeyGenerator;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:17
 */
public class IntegerGenerator implements PrimaryKeyGenerator<Integer> {
    private Integer next = 0;

    @Override
    public void initialize(@NotNull Collection<Integer> keys) {
        for (Integer key : keys) {
            if (next < key) {
                next = key;
            }
        }
    }

    @NotNull
    @Override
    public Integer next() {
        return ++next;
    }
}

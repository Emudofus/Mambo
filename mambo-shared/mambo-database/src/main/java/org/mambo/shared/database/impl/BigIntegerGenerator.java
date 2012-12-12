package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.PrimaryKeyGenerator;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:20
 */
public class BigIntegerGenerator implements PrimaryKeyGenerator<BigInteger> {
    private BigInteger next = BigInteger.ZERO;

    @Override
    public void initialize(@NotNull Iterable<? extends Entity> entities) {
        for (Entity entity : entities) {
            if (!(entity.getId() instanceof BigInteger)) {
                throw new IllegalArgumentException("entities must have a BigInteger id");
            }

            BigInteger id = (BigInteger) entity.getId();
            if (next.compareTo(id) < 0) {
                next = id;
            }
        }
    }

    @NotNull
    @Override
    public BigInteger next() {
        next = next.add(BigInteger.ONE);
        return next;
        //return ++next;
    }
}

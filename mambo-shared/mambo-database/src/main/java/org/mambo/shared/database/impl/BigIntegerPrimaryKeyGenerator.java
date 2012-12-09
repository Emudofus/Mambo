package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.PrimaryKeyGenerator;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:20
 */
public class BigIntegerPrimaryKeyGenerator implements PrimaryKeyGenerator<BigInteger> {
    private BigInteger next = BigInteger.ZERO;

    @Override
    public void initialize(@NotNull Collection<BigInteger> keys) {
        for (BigInteger key : keys) {
            if (next.compareTo(key) < 0) {
                next = key;
            }
        }
    }

    @NotNull
    @Override
    public BigInteger next() {
        next = next.add(BigInteger.ONE);
        return next;
    }
}

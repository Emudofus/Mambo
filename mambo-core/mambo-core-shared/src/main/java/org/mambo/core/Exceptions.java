package org.mambo.core;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 19:18
 */
public final class Exceptions extends HashSet<Throwable> {
    public static Exceptions create() {
        return new Exceptions();
    }

    private Exceptions() {}

    /**
     * throw all exceptions
     */
    public void throwAll() {
        if (size() <= 0) return;

        throw new MultipleExceptionsException(ImmutableSet.copyOf(this));
    }
}

package org.mambo.core;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 19:22
 */
public class MultipleExceptionsException extends RuntimeException {
    private final Set<Throwable> causes;

    public MultipleExceptionsException(@NotNull Set<Throwable> causes) {
        this.causes = checkNotNull(causes);
    }

    public Set<Throwable> getCauses() {
        return causes;
    }
}

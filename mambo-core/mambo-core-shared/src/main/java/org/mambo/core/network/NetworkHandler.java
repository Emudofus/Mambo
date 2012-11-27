package org.mambo.core.network;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 20/11/12
 * Time: 19:13
 */
public interface NetworkHandler<T extends NetworkClient> {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface Handler { }

    void connected(@NotNull T client);
    void disconnected(@NotNull T client);
}

package org.mambo.core.network;

import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 20/11/12
 * Time: 19:13
 */
public interface NetworkHandler<T extends NetworkClient> {
    public static @interface Handler { }

    void connected(@NotNull T client);
    void disconnected(@NotNull T client);
}

package org.mambo.core.network;

import org.mambo.core.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 18:28
 */
public interface NetworkHandlerManager<T extends NetworkClient> extends Iterable<NetworkHandler<T>> {
    void dispatchConnected(@NotNull T client);
    void dispatchDisconnected(@NotNull T client);
    void dispatchMessage(@NotNull T client, @NotNull Object message);
}

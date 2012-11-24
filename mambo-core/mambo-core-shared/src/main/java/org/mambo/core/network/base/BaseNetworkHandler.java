package org.mambo.core.network.base;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;
import org.mambo.core.network.NetworkHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:21
 */
public abstract class BaseNetworkHandler<T extends NetworkClient> implements NetworkHandler<T> {
    @Override
    public void connected(@NotNull T client) {

    }

    @Override
    public void disconnected(@NotNull T client) {

    }
}

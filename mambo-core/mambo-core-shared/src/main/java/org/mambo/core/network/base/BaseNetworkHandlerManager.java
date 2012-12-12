package org.mambo.core.network.base;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;
import org.mambo.core.network.NetworkHandler;
import org.mambo.core.network.NetworkHandlerManager;

import java.util.Iterator;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 19:28
 */
public abstract class BaseNetworkHandlerManager<T extends NetworkClient> implements NetworkHandlerManager<T>, Iterable<NetworkHandler<T>> {
    private final Set<NetworkHandler<T>> handlers;

    protected BaseNetworkHandlerManager(@NotNull Set<NetworkHandler<T>> handlers) {
        this.handlers = checkNotNull(handlers);
    }

    @Override
    public void dispatchConnected(@NotNull T client) {
        checkNotNull(client);

        for (NetworkHandler<T> handler : handlers) {
            handler.connected(client);
        }
    }

    @Override
    public void dispatchDisconnected(@NotNull T client) {
        checkNotNull(client);

        for (NetworkHandler<T> handler : handlers) {
            handler.disconnected(client);
        }
    }

    @Override
    public Iterator<NetworkHandler<T>> iterator() {
        return handlers.iterator();
    }
}

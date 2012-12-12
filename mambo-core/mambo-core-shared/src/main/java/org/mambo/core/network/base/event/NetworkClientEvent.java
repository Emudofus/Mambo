package org.mambo.core.network.base.event;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public abstract class NetworkClientEvent<T extends NetworkClient> {
    private final T client;

    public NetworkClientEvent(@NotNull T client) {
        this.client = checkNotNull(client);
    }

    @NotNull
    public T getClient() {
        return client;
    }
}

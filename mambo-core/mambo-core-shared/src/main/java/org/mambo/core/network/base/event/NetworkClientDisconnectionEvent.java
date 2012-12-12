package org.mambo.core.network.base.event;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;

/**
 * @author Blackrush
 *         Mambo
 */
public class NetworkClientDisconnectionEvent<T extends NetworkClient> extends NetworkClientEvent<T> {
    public NetworkClientDisconnectionEvent(@NotNull T client) {
        super(client);
    }
}

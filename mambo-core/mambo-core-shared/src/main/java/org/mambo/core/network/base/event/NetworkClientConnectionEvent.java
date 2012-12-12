package org.mambo.core.network.base.event;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;

/**
 * @author Blackrush
 *         Mambo
 */
public class NetworkClientConnectionEvent<T extends NetworkClient> extends NetworkClientEvent<T> {
    public NetworkClientConnectionEvent(@NotNull T client) {
        super(client);
    }
}

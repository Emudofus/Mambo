package org.mambo.core.network.base.event;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkClient;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public class NetworkClientMessageEvent<T extends NetworkClient> extends NetworkClientEvent<T> {
    private final Object message;

    public NetworkClientMessageEvent(@NotNull T client, @NotNull Object message) {
        super(client);
        this.message = checkNotNull(message);
    }

    @NotNull
    public Object getMessage() {
        return message;
    }
}

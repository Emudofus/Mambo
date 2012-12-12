package org.mambo.core.network.base;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.event.EventBus;
import org.mambo.core.event.Event;
import org.mambo.core.network.NetworkClient;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.base.event.NetworkClientConnectionEvent;
import org.mambo.core.network.base.event.NetworkClientDisconnectionEvent;
import org.mambo.core.network.base.event.NetworkClientMessageEvent;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public class EventBusNetworkHandlerManager<T extends NetworkClient> implements NetworkHandlerManager<T> {
    private final EventBus eventBus;

    public EventBusNetworkHandlerManager(@NotNull EventBus eventBus) {
        this.eventBus = checkNotNull(eventBus);
    }

    @Override
    public void dispatchConnected(@NotNull T client) {
        eventBus.publish(new NetworkClientConnectionEvent<T>(client));
    }

    @Override
    public void dispatchDisconnected(@NotNull T client) {
        eventBus.publish(new NetworkClientDisconnectionEvent<T>(client));
    }

    @Override
    public void dispatchMessage(@NotNull final T client, @NotNull Object message) {
        Event<NetworkClientMessageEvent<T>> event =
                eventBus.publish(new NetworkClientMessageEvent<T>(client, message));

        Futures.addCallback(event.getReplyFuture(), new FutureCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                client.getSession().write(result);
            }

            @Override
            public void onFailure(Throwable t) {}
        });
    }
}

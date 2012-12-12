package org.mambo.core.event;

import org.jetbrains.annotations.NotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public abstract class EventBus {
    /**
     * dispatch message to all handlers
     * @param message handler's message
     * @param <M> message's type
     * @return message's {@link Event}
     */
    @NotNull
    public abstract <M> Event<M> publish(@NotNull M message);

    /**
     * register a handler from this {@link EventBus}
     * @param handler handler to register
     */
    public abstract void register(@NotNull Object handler);

    /**
     * unregister a handler from this {@link EventBus}
     * @param handler handler to unregister
     */
    public abstract void unregister(@NotNull Object handler);
}

package org.mambo.core.event;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * a thread-unsafe {@link EventBus}
 *
 * @author Blackrush
 *         Mambo
 */
public class LightEventBus extends EventBus {
    /**
     * create a thread-unsafe {@link EventBus}
     * @param manager manager
     * @return created {@link EventBus}
     */
    public static LightEventBus create(@NotNull EventHandlerManager manager) {
        return new LightEventBus(manager);
    }

    private final Multimap<Class<?>, Object> handlers = HashMultimap.create();
    private final EventHandlerManager manager;

    LightEventBus(@NotNull EventHandlerManager manager) {
        this.manager = checkNotNull(manager);
    }

    @NotNull
    @Override
    public <M> EventInterface<M> publish(@NotNull M message) {
        EventInterface<M> event = new EventImpl<M>(message);
        manager.dispatch(handlers, event);
        return event;
    }

    @Override
    public void register(@NotNull Object handler) {
        checkNotNull(handler);
        handlers.put(handler.getClass(), handler);
        manager.onRegistered(handler.getClass());
    }

    @Override
    public void unregister(@NotNull Object handler) {
        checkNotNull(handler);
        handlers.remove(handler.getClass(), handler);
        manager.onUnregistered(handler.getClass());
    }
}

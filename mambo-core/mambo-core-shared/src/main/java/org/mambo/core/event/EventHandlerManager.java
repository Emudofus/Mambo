package org.mambo.core.event;

import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public abstract class EventHandlerManager {
    public abstract void onRegistered(@NotNull Class<?> handlerClass);
    public abstract void onUnregistered(@NotNull Class<?> handlerClass);

    public abstract void dispatch(@NotNull Multimap<Class<?>, Object> handlers, @NotNull EventInterface<?> event);
}

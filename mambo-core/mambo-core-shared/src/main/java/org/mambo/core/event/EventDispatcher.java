package org.mambo.core.event;

import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 19:04
 */
public interface EventDispatcher<T> {
    void dispatch(@NotNull T event);

    void register(@NotNull Object listener);
    void unregister(@NotNull Object listener);
}

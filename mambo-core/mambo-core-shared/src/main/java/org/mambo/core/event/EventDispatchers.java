package org.mambo.core.event;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 19/11/12
 * Time: 22:31
 */
public final class EventDispatchers {
    private EventDispatchers() {}

    @NotNull
    public static <T> EventDispatcher<T> light() {
        return new LightEventDispatcher<T>();
    }

    @NotNull
    public static <T> EventDispatcher<T> singleThreaded() {
        return new ThreadedEventDispatcher<T>(Executors.newSingleThreadExecutor());
    }

    @NotNull
    public static <T> EventDispatcher<T> threaded(@NotNull ExecutorService worker) {
        return new ThreadedEventDispatcher<T>(worker);
    }
}

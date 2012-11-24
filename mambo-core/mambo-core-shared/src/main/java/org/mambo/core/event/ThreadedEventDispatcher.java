package org.mambo.core.event;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 19:28
 */
public class ThreadedEventDispatcher<T> extends AbstractEventDispatcher<T> {
    private final ExecutorService worker;

    public ThreadedEventDispatcher(ExecutorService worker) {
        this.worker = worker;
    }

    @Override
    public void dispatch(@NotNull final T event) {
        worker.execute(new Runnable() {
            public void run() {
                dispatchEvent(event);
            }
        });
    }
}

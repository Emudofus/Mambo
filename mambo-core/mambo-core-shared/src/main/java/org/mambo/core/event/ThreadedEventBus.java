package org.mambo.core.event;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * a thread-safe {@link EventBus}
 * use a {@link Executor} to dispatch all the events
 *
 * @author Blackrush
 *         Mambo
 */
public class ThreadedEventBus extends EventBus {
    /**
     * create a thread-safe {@link EventBus}
     * @param manager manager
     * @param worker worker that will dispatch events
     * @return created {@link EventBus}
     */
    public static ThreadedEventBus create(@NotNull EventHandlerManager manager, @NotNull Executor worker) {
        return new ThreadedEventBus(manager, worker);
    }

    /**
     * create a thread-safe and single threaded {@link EventBus}
     * @param manager manager
     * @return created {@link EventBus}
     */
    public static ThreadedEventBus create(@NotNull EventHandlerManager manager) {
        return create(manager, Executors.newSingleThreadExecutor());
    }

    private final Multimap<Class<?>, Object> handlers = HashMultimap.create();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final EventHandlerManager manager;
    private final Executor worker;

    ThreadedEventBus(@NotNull EventHandlerManager manager, @NotNull Executor worker) {
        this.manager = checkNotNull(manager);
        this.worker = checkNotNull(worker);
    }

    @NotNull
    @Override
    public <M> Event<M> publish(@NotNull M message) {
        final Event<M> event = new EventImpl<M>(message);
        lock.readLock().lock();
        try {
            worker.execute(new Runnable() {
                public void run() {
                    manager.dispatch(handlers, event);
                }
            });
            return event;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void register(@NotNull Object handler) {
        checkNotNull(handler);
        lock.writeLock().lock();
        try {
            handlers.put(handler.getClass(), handler);
        } finally {
            lock.writeLock().unlock();
        }
        manager.onRegistered(handler.getClass());
    }

    @Override
    public void unregister(@NotNull Object handler) {
        checkNotNull(handler);
        lock.writeLock().lock();
        try {
            handlers.remove(handler.getClass(), handler);
        } finally {
            lock.writeLock().unlock();
        }
        manager.onUnregistered(handler.getClass());
    }
}

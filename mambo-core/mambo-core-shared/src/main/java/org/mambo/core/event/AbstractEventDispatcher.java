package org.mambo.core.event;

import com.google.common.collect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 19:05
 */
public abstract class AbstractEventDispatcher<T> implements EventDispatcher<T> {
    private static final Logger log = LoggerFactory.getLogger(AbstractEventDispatcher.class);

    private final List<Object> listeners = Lists.newArrayList();
    private final Map<Class<?>, Multimap<Class<?>, Method>> methodsCache = Maps.newIdentityHashMap();

    private final Lock lock = new ReentrantLock();

    protected void cache(Class<?> clazz) {
        // check if this class has already been cached
        for (Multimap<Class<?>, Method> methods : methodsCache.values()) {
            if (methods.containsKey(clazz)) {
                return;
            }
        }

        // add methods in the cache
        for (Method method : clazz.getMethods()) {
            EventListener annotation = method.getAnnotation(EventListener.class);
            if (annotation != null) {
                Multimap<Class<?>, Method> methods = methodsCache.get(annotation.value());
                if (methods == null) {
                    methods = HashMultimap.create(); // Set<E> implementation
                    methodsCache.put(annotation.value(), methods);
                }

                methods.put(clazz, method);
            }
        }
    }

    protected void dispatchEvent(T event) {
        lock.lock();
        try {
            Multimap<Class<?>, Method> methods = methodsCache.get(event.getClass());
            for (Object listener : listeners) {
                for (Method method : methods.get(listener.getClass())) {
                    try {
                        method.invoke(listener, event);
                    } catch (IllegalAccessException e) {
                        log.error("can't invoke method on " + listener.toString(), e);
                    } catch (InvocationTargetException e) {
                        log.error("listener has thrown an exception", e.getTargetException());
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void register(Object listener) {
        lock.lock();
        try {
            listeners.add(listener);
            cache(listener.getClass());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void unregister(Object listener) {
        lock.lock();
        try {
            listeners.remove(listener);
        } finally {
            lock.unlock();
        }
    }
}

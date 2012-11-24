package org.mambo.core.event;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 19:04
 */
public interface EventDispatcher<T> {
    void dispatch(T event);

    void register(Object listener);
    void unregister(Object listener);
}

package org.mambo.core.event;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 19:37
 */
public class LightEventDispatcher<T> extends AbstractEventDispatcher<T> {
    @Override
    public void dispatch(T event) {
        dispatchEvent(event);
    }
}

package org.mambo.core.event;

import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 19:37
 */
public class LightEventDispatcher<T> extends AbstractEventDispatcher<T> {
    @Override
    public void dispatch(@NotNull T event) {
        dispatchEvent(event);
    }
}

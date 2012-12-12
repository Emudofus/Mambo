package org.mambo.core.event;

import com.google.common.util.concurrent.ListenableFuture;
import org.jetbrains.annotations.NotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public interface Event<M> {
    /**
     * @return <code>true</code> if propagation has been stopped
     */
    boolean hasBeenStopped();

    /**
     * stop this event's propagation
     */
    void stopPropagation();

    /**
     * @return event's message
     */
    @NotNull
    M get();

    /**
     * reply to this event's sender
     * @param message reply
     */
    void reply(@NotNull Object message);

    /**
     * fired when replied
     * @return future reply's message
     */
    ListenableFuture<Object> getReplyFuture();
}

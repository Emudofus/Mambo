package org.mambo.core.event;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public class EventImpl<M> implements EventInterface<M> {
    private final M message;

    private boolean stopped;
    private SettableFuture<Object> replyFuture = SettableFuture.create();

    EventImpl(@NotNull M message) {
        this.message = checkNotNull(message);
    }

    @Override
    public boolean hasBeenStopped() {
        return stopped;
    }

    @Override
    public void stopPropagation() {
        stopped = true;
    }

    @NotNull
    @Override
    public M get() {
        return message;
    }

    @Override
    public void reply(@NotNull Object message) {
        replyFuture.set(message);
    }

    @Override
    public ListenableFuture<Object> getReplyFuture() {
        return replyFuture;
    }
}

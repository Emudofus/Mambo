package org.mambo.core.network.nio;

import com.google.common.util.concurrent.SettableFuture;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 16/12/12
 * Time: 22:13
 */
abstract class Request {
    private final NioSession session;
    private final SettableFuture<NioSession> future;

    private Request(@NotNull NioSession session, @NotNull SettableFuture<NioSession> future) {
        this.session = session;
        this.future = future;
    }

    @NotNull
    NioSession getSession() {
        return session;
    }

    @NotNull
    SettableFuture<NioSession> getFuture() {
        return future;
    }

    static class Write extends Request {
        private final Object message;

        private Write(@NotNull NioSession session, @NotNull SettableFuture<NioSession> future, Object message) {
            super(session, future);
            this.message = message;
        }

        @NotNull
        Object getMessage() {
            return message;
        }
    }

    static class Close extends Request {
        Close(@NotNull NioSession session, @NotNull SettableFuture<NioSession> future) {
            super(session, future);
        }
    }

    static Write write(@NotNull NioSession session, @NotNull SettableFuture<NioSession> future, @NotNull Object message) {
        return new Write(session, future, message);
    }

    static Write write(@NotNull NioSession session, @NotNull Object message) {
        return write(session, SettableFuture.<NioSession>create(), message);
    }

    static Close close(@NotNull NioSession session, @NotNull SettableFuture<NioSession> future) {
        return new Close(session, future);
    }

    static Close close(@NotNull NioSession session) {
        return close(session, SettableFuture.<NioSession>create());
    }
}

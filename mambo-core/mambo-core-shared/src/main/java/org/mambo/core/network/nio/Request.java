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
    private final SettableFuture<NioSession> future = SettableFuture.create();

    private Request(@NotNull NioSession session) {
        this.session = session;
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

        private Write(@NotNull NioSession session, @NotNull Object message) {
            super(session);
            this.message = message;
        }

        @NotNull
        Object getMessage() {
            return message;
        }
    }

    static class Close extends Request {
        private Close(@NotNull NioSession session) {
            super(session);
        }
    }

    static Write write(@NotNull NioSession session, @NotNull Object message) {
        return new Write(session, message);
    }

    static Close close(@NotNull NioSession session) {
        return new Close(session);
    }
}

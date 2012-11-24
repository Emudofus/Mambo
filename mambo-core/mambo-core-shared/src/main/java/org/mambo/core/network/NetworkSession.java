package org.mambo.core.network;

import com.google.common.util.concurrent.ListenableFuture;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 14:24
 */
public interface NetworkSession {
    @NotNull
    ListenableFuture<? extends NetworkSession> write(@NotNull Object msg);

    @NotNull
    ListenableFuture<? extends NetworkSession> close();

    void closeAndWait();
}

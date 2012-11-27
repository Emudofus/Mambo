package org.mambo.core.network;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Service;
import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 14:21
 */
public interface NetworkService extends Service {
    @NotNull
    ImmutableSet<? extends NetworkClient> getOnlineClients();

    int getLargestOnlineClients();

    Instant getStartupInstant();

    @NotNull
    NetworkProtocol getProtocol();

    @NotNull
    NetworkHandlerManager<? extends NetworkClient> getHandlerManager();
}

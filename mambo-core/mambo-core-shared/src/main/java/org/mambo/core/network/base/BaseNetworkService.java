package org.mambo.core.network.base;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joda.time.Instant;
import org.mambo.core.network.NetworkClient;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkService;
import org.mambo.core.network.NetworkSession;

import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 15:10
 */
public abstract class BaseNetworkService<T extends NetworkClient> extends AbstractIdleService implements NetworkService {
    private final Set<T> clients = Sets.newHashSet();
    private final NetworkHandlerManager<T> networkHandlerManager;

    private Instant startUpInstant;
    private int largestOnlineClients;

    protected BaseNetworkService(@NotNull NetworkHandlerManager<T> networkHandlerManager) {
        this.networkHandlerManager = checkNotNull(networkHandlerManager);
    }

    protected abstract void configure();
    protected abstract void bind() throws Exception;
    protected abstract void unbind() throws Exception;

    @Override
    protected void startUp() throws Exception {
        startUpInstant = Instant.now();

        configure();
        bind();
    }

    @Override
    protected void shutDown() throws Exception {
        List<ListenableFuture<? extends NetworkSession>> futures = Lists.newArrayList();
        for (T client : clients) {
            ListenableFuture<? extends NetworkSession> future = client.getSession().close();
            futures.add(future);
        }
        Futures.allAsList(futures).get();

        unbind();
    }

    @NotNull
    @Override
    public ImmutableSet<T> getOnlineClients() {
        return ImmutableSet.copyOf(clients);
    }

    protected void addClient(T client) {
        clients.add(client);
        if (clients.size() > largestOnlineClients) {
            largestOnlineClients = clients.size();
        }
    }

    @Override
    public int getLargestOnlineClients() {
        return largestOnlineClients;
    }

    @Nullable
    @Override
    public Instant getStartupInstant() {
        return startUpInstant;
    }

    @NotNull
    @Override
    public NetworkHandlerManager<T> getHandlerManager() {
        return networkHandlerManager;
    }
}

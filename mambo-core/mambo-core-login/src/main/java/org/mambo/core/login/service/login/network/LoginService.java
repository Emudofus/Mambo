package org.mambo.core.login.service.login.network;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.NetworkService;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:10
 */
public interface LoginService extends NetworkService {
    @NotNull
    @Override
    ImmutableSet<LoginClient> getOnlineClients();

    @NotNull
    @Override
    NetworkHandlerManager<LoginClient> getHandlerManager();
}

package org.mambo.core.network;

import org.mambo.core.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 18/11/12
 * Time: 14:24
 */
public interface NetworkClient {
    @NotNull
    NetworkService getService();

    @NotNull
    NetworkSession getSession();
}

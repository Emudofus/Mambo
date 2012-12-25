package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.login.database.model.User;

import java.security.PublicKey;

/**
 * handles crypto and client's auth
 *
 * @author Blackrush
 *         Mambo
 */
public interface LoginCryptoService {
    @NotNull
    PublicKey getPublicKey();

    /**
     * decrypt credentials and return a valid user
     * @param credentials crypted credentials
     * @return found user
     * @throws AuthenticationException
     */
    @NotNull
    User authenticate(byte[] credentials);
}

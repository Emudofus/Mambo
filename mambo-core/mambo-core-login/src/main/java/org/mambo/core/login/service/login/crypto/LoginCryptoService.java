package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.login.database.model.User;

import java.security.PublicKey;

/**
 * @author Blackrush
 *         Mambo
 */
public interface LoginCryptoService {
    @NotNull
    PublicKey getPublicKey();

    @NotNull
    User find(byte[] bytes);
}

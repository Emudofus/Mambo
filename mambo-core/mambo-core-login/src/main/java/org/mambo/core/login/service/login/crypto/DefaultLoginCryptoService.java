package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.login.database.model.User;

import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 16/12/12
 * Time: 21:51
 */
public class DefaultLoginCryptoService implements LoginCryptoService {


    @NotNull
    @Override
    public PublicKey getPublicKey() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public User find(byte[] bytes) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

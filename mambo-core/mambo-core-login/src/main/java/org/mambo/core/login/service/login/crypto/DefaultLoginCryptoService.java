package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.login.database.model.User;
import org.mambo.shared.database.Repository;

import javax.inject.Inject;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 16/12/12
 * Time: 21:51
 */
public class DefaultLoginCryptoService implements LoginCryptoService {
    public static final int DEFAULT_KEYSIZE = 2048;

    private static KeyPair generateKeyPair(int keysize) {
        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("unknown RSA algorithm", e);
        }

        generator.initialize(keysize);
        return generator.generateKeyPair();
    }

    private final KeyPair keys;
    private final Repository<User> users;

    @Inject
    public DefaultLoginCryptoService(ConfigurationProvider config, Repository<User> users) {
        this.keys = generateKeyPair(config.getInt("services.login.crypto.keysize", DEFAULT_KEYSIZE));
        this.users = users;
    }

    @NotNull
    @Override
    public PublicKey getPublicKey() {
        return keys.getPublic();
    }

    @NotNull
    @Override
    public User find(byte[] bytes) {
        return users.find("username", "foo"); // TODO
    }
}

package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.login.database.model.User;
import org.mambo.shared.database.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.inject.Inject;
import java.security.*;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 16/12/12
 * Time: 21:51
 */
public class DefaultLoginCryptoService implements LoginCryptoService {
    public static final int DEFAULT_KEYSIZE = 1024;
    public static final String DEFAULT_DIGEST_NAME = "SHA1";

    public static final String ALGORITHM_NAME = "RSA";
    public static final int SALT_SIZE = 32;

    private final KeyPair keys;
    private final Cipher decrypter;
    private final MessageDigest digest;
    private final Repository<User> users;

    @Inject
    public DefaultLoginCryptoService(ConfigurationProvider config, Repository<User> users)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
    {
        this.users = users;

        // generate public and private RSA keys
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM_NAME);
        generator.initialize(config.getInt("services.login.crypto.keysize", DEFAULT_KEYSIZE));
        this.keys = generator.generateKeyPair();

        // get RSA decrypter and initialize it with previously generated private key
        this.decrypter = Cipher.getInstance(ALGORITHM_NAME);
        this.decrypter.init(Cipher.DECRYPT_MODE, this.keys.getPrivate());

        // get digest for user's password
        this.digest = MessageDigest.getInstance(config.getString("services.login.crypto.digest", DEFAULT_DIGEST_NAME));
    }

    @NotNull
    @Override
    public PublicKey getPublicKey() {
        return keys.getPublic();
    }

    /**
     * @todo
     */
    private String digest(String password, String salt) {
        throw new NotImplementedException();
    }

    private User authenticate(String username, String password) {
        User user = users.find("username", username);

        if (user == null) {
            throw new BadCredentialsException("unknown username");
        }

        String passwordHash = digest(password, user.getSalt());
        if (!passwordHash.equals(user.getPasswordHash())) {
            throw new BadCredentialsException("invalid password");
        }

        return user;
    }

    private String extract(byte[] decrypted, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder(end - start);
        for (int i = start; i < end; ++i) {
            stringBuilder.append((char) decrypted[i]);
        }
        return stringBuilder.toString();
    }

    private String extractSalt(byte[] decrypted) {
        return extract(decrypted, 0, SALT_SIZE);
    }

    private String extractUsername(byte[] decrypted) {
        int length = decrypted[SALT_SIZE];
        return extract(decrypted, SALT_SIZE + 1, SALT_SIZE + 1 + length);
    }

    private String extractPassword(byte[] decrypted) {
        int usernameLength = decrypted[SALT_SIZE];
        return extract(decrypted, SALT_SIZE + 1 + usernameLength, decrypted.length);
    }

    @NotNull
    @Override
    public User find(byte[] bytes) {
        byte[] decrypted;
        try {
            decrypted = decrypter.doFinal(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return authenticate(extractUsername(decrypted), extractPassword(decrypted));
    }
}

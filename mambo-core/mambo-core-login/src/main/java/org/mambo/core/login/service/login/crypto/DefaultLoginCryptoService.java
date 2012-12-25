package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.cipher.CipherInterface;
import org.mambo.core.cipher.DigestCipher;
import org.mambo.core.cipher.RSACiphers;
import org.mambo.core.cipher.RSADecrypterCipher;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.login.database.model.User;
import org.mambo.protocol.client.enums.IdentificationFailureReasonEnum;
import org.mambo.shared.database.Repository;

import javax.inject.Inject;
import java.security.KeyPair;
import java.security.PublicKey;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * an easily overridable and default {@link LoginCryptoService}
 *
 * @author Blackrush
 */
public class DefaultLoginCryptoService implements LoginCryptoService {
    public static final int DEFAULT_KEYSIZE = 1024;
    public static final String DEFAULT_DIGEST_NAME = "SHA1";
    public static final int SALT_SIZE = 32;

    public static String extract(byte[] decrypted, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder(end - start);
        for (int i = start; i < end; ++i) {
            stringBuilder.append((char) decrypted[i]);
        }
        return stringBuilder.toString();
    }

    public static String extractTicket(byte[] decrypted) {
        return extract(decrypted, 0, SALT_SIZE);
    }

    public static String extractUsername(byte[] decrypted) {
        int length = decrypted[SALT_SIZE];
        return extract(decrypted, SALT_SIZE + 1, SALT_SIZE + 1 + length);
    }

    public static String extractPassword(byte[] decrypted) {
        int usernameLength = decrypted[SALT_SIZE];
        return extract(decrypted, SALT_SIZE + 1 + usernameLength, decrypted.length);
    }

    private final KeyPair keys;
    protected final CipherInterface decrypter, digest;
    protected final Repository<User> users;

    @Inject
    public DefaultLoginCryptoService(ConfigurationProvider config, Repository<User> users) {
        this.users = users;
        this.keys = RSACiphers.generateKeys(config.getInt("services.login.crypto.keysize", DEFAULT_KEYSIZE));
        this.decrypter = RSADecrypterCipher.forKeys(this.keys);
        this.digest = DigestCipher.forName(config.getString("services.login.crypto.digest", DEFAULT_DIGEST_NAME));
    }

    @NotNull
    @Override
    public PublicKey getPublicKey() {
        return keys.getPublic();
    }

    protected String digest(@NotNull User user, @NotNull String password) {
        return digest.hexcipher(password, user.getSalt());
    }

    /**
     * @param user found user (or not if null)
     * @param password sent password
     * @param ticket session's ticket
     * @throws AuthenticationException
     */
    protected void assertValid(User user, @NotNull String password, @NotNull String ticket) {
        if (user == null) {
            throw new AuthenticationException("unknown user", IdentificationFailureReasonEnum.WRONG_CREDENTIALS);
        }

        String passwordHash = digest(user, password);
        if (!passwordHash.equals(user.getPasswordHash())) {
            throw new AuthenticationException("wrong password", IdentificationFailureReasonEnum.WRONG_CREDENTIALS);
        }

        if (user.isBanned()) {
            throw new AuthenticationException(IdentificationFailureReasonEnum.BANNED);
        }
    }

    @NotNull
    protected User authenticate(@NotNull String username, @NotNull String password, @NotNull String ticket) {
        User user = users.find("username", username);
        assertValid(user, password, ticket);
        return checkNotNull(user);
    }

    @NotNull
    @Override
    public User authenticate(byte[] credentials) {
        byte[] decrypted = decrypter.cipher(credentials);
        return authenticate(extractUsername(decrypted), extractPassword(decrypted), extractTicket(decrypted));
    }
}

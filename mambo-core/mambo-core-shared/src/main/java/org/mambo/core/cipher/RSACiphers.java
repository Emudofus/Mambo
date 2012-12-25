package org.mambo.core.cipher;

import org.jetbrains.annotations.NotNull;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author Blackrush
 */
public final class RSACiphers {
    public static final String ALGORITHM_NAME = "RSA";

    private RSACiphers() {}

    @NotNull
    public static KeyPair generateKeys(int keysize) {
        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance(ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        generator.initialize(keysize);
        return generator.generateKeyPair();
    }
}

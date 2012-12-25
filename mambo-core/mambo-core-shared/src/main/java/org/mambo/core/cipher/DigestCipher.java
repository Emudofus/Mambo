package org.mambo.core.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Blackrush
 */
public class DigestCipher extends AbstractCipher {
    public static DigestCipher forName(String name) {
        return new DigestCipher(name);
    }

    public static DigestCipher md5() {
        return forName("MD5");
    }

    public static DigestCipher sha(int n) {
        return forName("SHA-" + n);
    }

    public static DigestCipher sha1() {
        return sha(1);
    }

    public static DigestCipher sha256() {
        return sha(256);
    }

    public static DigestCipher sha512() {
        return sha(512);
    }

    private final MessageDigest digest;

    private DigestCipher(String name) {
        try {
            this.digest = MessageDigest.getInstance(name);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("unknown cipher algorithm \"" + name + "\"", e);
        }
    }

    @Override
    public byte[] cipher(byte[] input) {
        return digest.digest(input);
    }
}

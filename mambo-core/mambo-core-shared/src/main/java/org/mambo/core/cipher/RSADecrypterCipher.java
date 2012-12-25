package org.mambo.core.cipher;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.PrivateKey;

/**
 * @author Blackrush
 */
public class RSADecrypterCipher extends AbstractStandardCipher {
    public static RSADecrypterCipher forPrivateKey(PrivateKey privateKey) {
        return new RSADecrypterCipher(privateKey);
    }

    public static RSADecrypterCipher forKeys(KeyPair pair) {
        return forPrivateKey(pair.getPrivate());
    }

    private RSADecrypterCipher(PrivateKey privateKey) {
        super("RSA");
        try {
            super.cipher.init(Cipher.DECRYPT_MODE, privateKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] cipher(byte[] input, byte[] salt) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String hexcipher(String input, String salt) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String cipher(String input, String salt) {
        throw new UnsupportedOperationException();
    }
}

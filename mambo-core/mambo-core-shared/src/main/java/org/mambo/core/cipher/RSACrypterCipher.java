package org.mambo.core.cipher;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.PublicKey;

/**
 * @author Blackrush
 */
public class RSACrypterCipher extends AbstractStandardCipher {
    public static RSACrypterCipher forPublicKey(PublicKey publicKey) {
        return new RSACrypterCipher(publicKey);
    }

    public static RSACrypterCipher forKeys(KeyPair keyPair) {
        return forPublicKey(keyPair.getPublic());
    }

    private RSACrypterCipher(PublicKey publicKey) {
        super("RSA");
        try {
            super.cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

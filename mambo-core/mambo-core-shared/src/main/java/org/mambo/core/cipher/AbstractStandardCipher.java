package org.mambo.core.cipher;

import javax.crypto.Cipher;

/**
 * @author Blackrush
 */
public abstract class AbstractStandardCipher extends AbstractCipher {
    protected final Cipher cipher;

    protected AbstractStandardCipher(String algorithmName) {
        try {
            this.cipher = Cipher.getInstance(algorithmName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] cipher(byte[] input) {
        try {
            return cipher.doFinal(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

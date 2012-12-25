package org.mambo.core.cipher;

import org.mambo.core.Strings;

/**
 * @author Blackrush
 */
public abstract class AbstractCipher implements CipherInterface {
    public static final int RADIX = 16;

    public static byte[] concat(byte[] left, byte[] right) {
        byte[] result = new byte[left.length + right.length];

        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(right, 0, result, left.length, right.length);

        return result;
    }

    @Override
    public byte[] cipher(byte[] input, byte[] salt) {
        return cipher(concat(cipher(input), salt));
    }

    @Override
    public String hexcipher(String input) {
        return Strings.representation(cipher(input.getBytes()), RADIX);
    }

    @Override
    public String hexcipher(String input, String salt) {
        return hexcipher(hexcipher(input) + salt);
    }

    @Override
    public String cipher(String input) {
        return hexcipher(input);
    }

    @Override
    public String cipher(String input, String salt) {
        return cipher(cipher(input) + salt);
    }
}

package org.mambo.core.cipher;

/**
 * @author Blackrush
 */
public interface CipherInterface {
    byte[] cipher(byte[] input);
    byte[] cipher(byte[] input, byte[] salt);
    String cipher(String input);
    String cipher(String input, String salt);
    String hexcipher(String input);
    String hexcipher(String input, String salt);
}

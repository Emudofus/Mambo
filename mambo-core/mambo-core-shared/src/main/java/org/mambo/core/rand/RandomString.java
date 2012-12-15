package org.mambo.core.rand;

import java.util.Random;

/**
 * @author Blackrush
 *         Mambo
 */
public final class RandomString {
    private RandomString() {}

    public static final String LOWER_ALPHABET = "acbcdefghijklmnopqrstuvwxz",
                               UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generate(int length) {
        return generate(LOWER_ALPHABET, length);
    }

    public static String generate(String alphabet, int length) {
        Random random = new Random(System.nanoTime());
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; ++i) {
            char character = alphabet.charAt(random.nextInt(alphabet.length()));
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    public static String pseudo() {
        Random random = new Random(System.nanoTime());

        int length = random.nextInt(5) + 4; // [4;9[
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; ++i) {
            String alphabet = i == 0 ? UPPER_ALPHABET : LOWER_ALPHABET;
            char character = alphabet.charAt(random.nextInt(alphabet.length()));
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}

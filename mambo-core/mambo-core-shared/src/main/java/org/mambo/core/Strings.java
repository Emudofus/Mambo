package org.mambo.core;

import org.jetbrains.annotations.NotNull;

/**
 * @author Blackrush
 */
public final class Strings {
    private Strings() {}

    @NotNull
    public static String representation(byte[] bytes, int radix) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte val : bytes) {
            String repr = Integer.toString(0xFF & val, radix);
            if (repr.length() == 1) {
                builder.append('0');
            }
            builder.append(repr);
        }
        return builder.toString();
    }
}

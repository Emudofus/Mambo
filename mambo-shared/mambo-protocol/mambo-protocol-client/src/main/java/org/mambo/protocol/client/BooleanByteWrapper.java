package org.mambo.protocol.client;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 11/11/12
 * Time: 18:26
 * thanks bouh2 (BiM.Protocol)
 */
public final class BooleanByteWrapper {
    private BooleanByteWrapper() {}

    public static short setFlag(short flag, int offset, boolean value) {
        if (offset >= 8)
            throw new IllegalArgumentException("offset must be >= 8");

        return value ? (byte) (flag | (1 << offset)) : (byte)(flag & 255 - (1 << offset));
    }

    public static boolean getFlag(short flag, int offset) {
        if (offset >= 8)
            throw new IllegalArgumentException("offset must be >= 8");

        return (flag & (byte) (1 << offset)) != 0;
    }
}

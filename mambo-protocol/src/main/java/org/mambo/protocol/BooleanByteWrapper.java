package org.mambo.protocol;

/**
 * @author Blackrush
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

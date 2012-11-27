package org.mambo.core.network;

import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:49
 */
public interface NetworkProtocol {
    public static interface Encoder {
        byte[] encode(@NotNull Object msg);
    }

    public static interface Decoder {
        Object decode(@NotNull byte[] buf);
    }

    boolean canHandle(@NotNull Object msg);

    @NotNull
    Encoder getEncoder();

    @NotNull
    Decoder getDecoder();
}

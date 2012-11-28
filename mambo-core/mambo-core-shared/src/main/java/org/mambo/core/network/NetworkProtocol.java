package org.mambo.core.network;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.io.DataReaderInterface;
import org.mambo.core.io.DataWriterInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:49
 */
public interface NetworkProtocol {
    public static interface Encoder {
        DataWriterInterface encode(@NotNull Object msg);
    }

    public static interface Decoder {
        Object decode(@NotNull DataReaderInterface buf);
    }

    boolean canHandle(@NotNull Object msg);

    @NotNull
    DataReaderInterface newReader(byte[] bytes, int offset);

    @NotNull
    DataWriterInterface newWriter();

    @NotNull
    Encoder getEncoder();

    @NotNull
    Decoder getDecoder();
}

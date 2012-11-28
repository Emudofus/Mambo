package org.mambo.protocol.client;

import org.jetbrains.annotations.NotNull;
import org.mambo.core.io.BigEndianDataReader;
import org.mambo.core.io.BigEndianDataWriter;
import org.mambo.core.io.DataReaderInterface;
import org.mambo.core.io.DataWriterInterface;
import org.mambo.core.network.NetworkProtocol;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 19:16
 */
public class DofusProtocol implements NetworkProtocol {
    private final Encoder encoder = new DofusEncoder();
    private final Decoder decoder = new DofusDecoder();

    private final MessageReceiver messageReceiver;
    private final int initialCapacity;

    public DofusProtocol(@NotNull MessageReceiver messageReceiver, int initialCapacity) {
        this.messageReceiver = checkNotNull(messageReceiver);
        this.initialCapacity = initialCapacity;
    }

    @Override
    public boolean canHandle(@NotNull Object msg) {
        return msg instanceof NetworkMessage;
    }

    @NotNull
    @Override
    public DataReaderInterface newReader(byte[] bytes, int offset) {
        return new BigEndianDataReader(bytes, offset);
    }

    @NotNull
    @Override
    public DataWriterInterface newWriter() {
        return newWriter(initialCapacity);
    }

    @NotNull
    public DataWriterInterface newWriter(int initialCapacity) {
        return new BigEndianDataWriter(initialCapacity);
    }

    @NotNull
    @Override
    public Encoder getEncoder() {
        return encoder;
    }

    @NotNull
    @Override
    public Decoder getDecoder() {
        return decoder;
    }

    private static final int BIT_RIGHT_SHIFT_LEN_PACKET_ID = 2;
    private static final int BIT_MASK = 3;

    private static int computeTypeLen(int len) {
        return len > 65535 ? 3 :
               len > 255   ? 2 :
               len > 0     ? 1 :
                             0;
    }

    private static int subComputeStaticHeader(int networkMessageId, int typeLen) {
        return networkMessageId << BIT_RIGHT_SHIFT_LEN_PACKET_ID | typeLen;
    }

    private static int getMessageId(int header) {
        return header >> BIT_RIGHT_SHIFT_LEN_PACKET_ID;
    }

    private static int getTypeLen(int header) {
        return header & BIT_MASK;
    }

    private class DofusEncoder implements Encoder {
        @Override
        public DataWriterInterface encode(@NotNull Object o) {
            if (!(o instanceof NetworkMessage)) return null;
            NetworkMessage message = (NetworkMessage) o;
            DataWriterInterface messageWriter = newWriter();
            message.serialize(messageWriter);
            messageWriter.reduce();

            int length = messageWriter.getLength();
            int typeLen = computeTypeLen(length);
            DataWriterInterface writer = newWriter(2 + typeLen + length);

            writer.writeShort((short) subComputeStaticHeader(message.getNetworkMessageId(), typeLen));
            switch (typeLen) {
            case 1:
                writer.writeUnsignedByte((short) length);
                break;
            case 2:
                writer.writeShort((short) length);
                break;
            case 3:
                writer.writeUnsignedByte((short) (length >> 16 & 0xFF));
                writer.writeShort((short) (length & 0xFFFF));
                break;
            }
            writer.writeBytes(messageWriter.getData());

            return writer;
        }
    }

    private class DofusDecoder implements Decoder {
        @Override
        public Object decode(@NotNull DataReaderInterface reader) {
            if (reader.getRemaining() < 2) return null; // can't read header

            int header = reader.readShort(),
                messageId = getMessageId(header),
                typeLen = getTypeLen(header);

            NetworkMessage message = messageReceiver.build(messageId);
            if (message == null) {
                throw new RuntimeException("unknown message " + messageId);
            }

            int length;
            switch (typeLen) {
            case 0:
                return message;
            case 1:
                length = reader.readUnsignedByte();
                break;
            case 2:
                length = reader.readShort();
                break;
            case 3:
                length = ((reader.readByte() & 0xFF) << 16) + ((reader.readByte() & 0xFF) << 8) + (reader.readByte() & 0xFF);
                break;
            default:
                throw new RuntimeException("bad type length " + typeLen);
            }

            if (reader.getRemaining() < length) return null; // can't read complete message

            message.deserialize(reader);
            return message;
        }
    }
}

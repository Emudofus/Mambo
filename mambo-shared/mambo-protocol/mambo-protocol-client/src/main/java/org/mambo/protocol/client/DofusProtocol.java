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
        public byte[] encode(@NotNull Object o) {
            if (!(o instanceof NetworkMessage)) return null;

            NetworkMessage msg = (NetworkMessage) o;
            DataWriterInterface writer = new BigEndianDataWriter(initialCapacity);
            msg.serialize(writer);

            writer.reduce();
            writer.setOffset(0);

            int len = writer.getLength();
            int typeLen = computeTypeLen(len);
            writer.shiftRight(2 + typeLen);

            writer.writeShort((short) subComputeStaticHeader(msg.getNetworkMessageId(), typeLen));

            switch (typeLen) {
            case 1:
                writer.writeUnsignedByte((short) len);
                break;
            case 2:
                writer.writeShort((short) len);
                break;
            case 3:
                writer.writeUnsignedByte((short) (len >> 16 & 0xFF));
                writer.writeShort((short) (len & 0xFFFF));
                break;
            }

            writer.setOffset(2 + typeLen + len);
            writer.reduce();
            return writer.getData();
        }
    }

    private class DofusDecoder implements Decoder {
        @Override
        public Object decode(@NotNull byte[] buf) {
            if (buf.length < 2) return null;

            DataReaderInterface reader = new BigEndianDataReader(buf);

            short header = reader.readShort();

            int networkMessageId = getMessageId(header),
                typeLen          = getTypeLen(header);

            if (typeLen < 0) {
                throw new RuntimeException("malformated message");
            } else if (typeLen == 0) {
                return messageReceiver.build(networkMessageId);
            } else {
                int length;
                switch (typeLen) {
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
                    throw new RuntimeException("malformated header");
                }

                if (reader.getRemaining() < length) {
                    return null;
                } else {
                    NetworkMessage message = messageReceiver.build(networkMessageId);
                    message.deserialize(reader);

                    return message;
                }
            }
        }
    }
}

package org.mambo.core.io;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 18:58
 */
public class BigEndianDataReader implements DataReaderInterface {
    public static final Charset CHARSET = Charset.forName("UTF8");

    private byte[] data;
    private int offset;

    public BigEndianDataReader(byte[] data, int offset) {
        this.data = data;
        this.offset = offset;
    }

    public BigEndianDataReader(byte[] data) {
        this(data, 0);
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getRemaining() {
        return data.length - offset;
    }

    @Override
    public byte readByte() {
        byte value = data[offset];
        offset++;
        return value;
    }

    @Override
    public short readUnsignedByte() {
        return (short) (readByte() & 0xFF);
    }

    @Override
    public byte[] readBytes(int n) {
        byte[] value = new byte[n];
        for (int i = 0; i < n; ++i) {
            value[i] = readByte();
        }
        return value;
    }

    @Override
    public short readShort() {
        return (short) ((readUnsignedByte() << 8) | readUnsignedByte());
    }

    @Override
    public int readUnsignedShort() {
        return (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override
    public int readInt() {
        return (readUnsignedShort() << 16) | readUnsignedShort();
    }

    @Override
    public long readUnsignedInt() {
        return ((long) readUnsignedShort() << 16) | (long) readUnsignedShort();
    }

    @Override
    public long readLong() {
        return (readUnsignedInt() << 32) | readUnsignedInt();
    }

    @Override
    public BigInteger readUnsignedLong() {
        return BigInteger.ZERO
              .add(BigInteger.valueOf(readUnsignedInt())).shiftLeft(32)
              .or(BigInteger.valueOf(readUnsignedInt()));
    }

    @Override
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override
    public char readChar() {
        return CHARSET.decode(ByteBuffer.wrap(data, offset++, 1)).charAt(0);
    }

    @Override
    public boolean readBoolean() {
        return readByte() == 1;
    }

    @Override
    public String readString() {
        int length = readUnsignedShort();
        byte[] bytes = readBytes(length);
        return new String(bytes, CHARSET);
    }
}

package org.mambo.core.io;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 21:23
 */
public class BigEndianDataWriter implements DataWriterInterface {
    public static final BigInteger MASK = BigInteger.valueOf(0xFF);
    public static final Charset CHARSET = Charset.forName("UTF8");

    private byte[] data;
    private int offset;

    public BigEndianDataWriter(int capacity) {
        data = new byte[capacity];
    }

    public BigEndianDataWriter() {
        this(10);
    }

    private boolean hasEnoughBytes(int n) {
        return offset + n <= data.length;
    }

    private void ensureEnoughBytes(int n) {
        if (!hasEnoughBytes(n)) {
            byte[] backup = data;
            data = new byte[data.length + n * 2];
            System.arraycopy(backup, 0, data, 0, backup.length);
        }
    }

    private byte[] reduceBytes() {
        byte[] reduced = new byte[offset + 1];
        System.arraycopy(data, 0, reduced, 0, offset);
        return reduced;
    }

    @Override
    public int getLength() {
        return data.length;
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
    public byte[] getData() {
        return data;
    }

    @Override
    public void reduce() {
        byte[] copied = new byte[offset];
        System.arraycopy(data, 0, copied, 0, offset);
        data = copied;
    }

    @Override
    public void shiftRight(int n) {
        byte[] copied = new byte[n + data.length];
        System.arraycopy(data, 0, copied, 0, offset);
        System.arraycopy(data, offset, copied, offset + n, data.length - offset);
        data = copied;
    }

    @Override
    public void shiftLeft(int n) {
        byte[] copied = new byte[data.length - n];
        System.arraycopy(data, n, copied, 0, data.length - n);
        data = copied;
        offset -= n;
    }

    @Override
    public void writeByte(byte value) {
        ensureEnoughBytes(1);
        data[offset++] = value;
    }

    @Override
    public void writeUnsignedByte(short value) {
        ensureEnoughBytes(1);
        data[offset++] = (byte) (value & 0xFF);
    }

    @Override
    public void writeBytes(byte[] bytes) {
        ensureEnoughBytes(bytes.length);
        System.arraycopy(bytes, 0, data, offset, bytes.length);
        offset += bytes.length;
    }

    @Override
    public void writeShort(short value) {
        ensureEnoughBytes(2);
        data[offset++] = (byte) (value >> 8);
        data[offset++] = (byte) (value & 0xFF);
    }

    @Override
    public void writeUnsignedShort(int value) {
        ensureEnoughBytes(2);
        data[offset++] = (byte) (value >> 8);
        data[offset++] = (byte) (value & 0xFF);
    }

    @Override
    public void writeInt(int value) {
        ensureEnoughBytes(4);
        data[offset++] = (byte) (value >> 24);
        data[offset++] = (byte) ((value >> 16) & 0xFF);
        data[offset++] = (byte) ((value >> 8) & 0xFF);
        data[offset++] = (byte) (value & 0xFF);
    }

    @Override
    public void writeUnsignedInt(long value) {
        ensureEnoughBytes(4);
        data[offset++] = (byte) (value >> 24);
        data[offset++] = (byte) ((value >> 16) & 0xFF);
        data[offset++] = (byte) ((value >> 8) & 0xFF);
        data[offset++] = (byte) (value & 0xFF);
    }

    @Override
    public void writeLong(long value) {
        ensureEnoughBytes(8);
        data[offset++] = (byte) (value >> 56);
        data[offset++] = (byte) ((value >> 48) & 0xFF);
        data[offset++] = (byte) ((value >> 40) & 0xFF);
        data[offset++] = (byte) ((value >> 32) & 0xFF);
        data[offset++] = (byte) ((value >> 24) & 0xFF);
        data[offset++] = (byte) ((value >> 16) & 0xFF);
        data[offset++] = (byte) ((value >> 8) & 0xFF);
        data[offset++] = (byte) (value & 0xFF);
    }

    @Override
    public void writeUnsignedLong(BigInteger value) {
        ensureEnoughBytes(8);
        data[offset++] = value.shiftRight(56).byteValue();
        data[offset++] = value.shiftRight(48).and(MASK).byteValue();
        data[offset++] = value.shiftRight(40).and(MASK).byteValue();
        data[offset++] = value.shiftRight(32).and(MASK).byteValue();
        data[offset++] = value.shiftRight(24).and(MASK).byteValue();
        data[offset++] = value.shiftRight(16).and(MASK).byteValue();
        data[offset++] = value.shiftRight(8).and(MASK).byteValue();
        data[offset++] = value.and(MASK).byteValue();
    }

    @Override
    public void writeDouble(double value) {
        writeLong(Double.doubleToLongBits(value));
    }

    @Override
    public void writeFloat(float value) {
        writeInt(Float.floatToIntBits(value));
    }

    @Override
    public void writeChar(char value) {
        ensureEnoughBytes(1);
        data[offset++] = CHARSET.encode(CharBuffer.wrap(new char[] { value })).get();
    }

    @Override
    public void writeBoolean(boolean value) {
        ensureEnoughBytes(1);
        writeByte((byte) (value ? 1 : 0));
    }

    @Override
    public void writeString(String value) {
        ensureEnoughBytes(2 + value.length());

        writeUnsignedShort(value.length());

        ByteBuffer buffer = CHARSET.encode(value);
        for (int i = 0; i < value.length(); ++i) {
            data[offset++] = buffer.get();
        }
    }
}

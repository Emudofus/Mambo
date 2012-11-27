package org.mambo.core.io;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 18:44
 */
public interface DataWriterInterface {
    int getLength();

    int getOffset();
    void setOffset(int offset);

    void writeByte(byte value);
    void writeUnsignedByte(short value);

    void writeBytes(byte[] bytes);

    void writeShort(short value);
    void writeUnsignedShort(int value);

    void writeInt(int value);
    void writeUnsignedInt(long value);

    void writeLong(long value);
    void writeUnsignedLong(BigInteger value);

    void writeDouble(double value);
    void writeFloat(float value);

    void writeChar(char value);

    void writeBoolean(boolean value);

    void writeString(String value);

    byte[] getData();

    void reduce();
    void shiftRight(int n);
    void shiftLeft(int n);
}

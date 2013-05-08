package org.mambo.core.io;

import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * @author Blackrush
 */
public interface Buffer {
    int offset();
    void setOffset(int offset);

    byte[] data();
    byte[] rawData();
    int remaining();

    Buffer compact();
    ByteBuffer toByteBuffer();

    void shiftLeft(int length);
    void shiftRight(int length);

    byte[] readBytes();
    byte[] readBytes(int length);
    void writeBytes(byte[] bytes);
    void writeBytes(byte[] bytes, int offset, int length);

    void writeArray(byte[] bytes);
    void writeArray(byte[] bytes, int offset, int length);

    byte readByte();
    void writeByte(byte b);

    boolean readBoolean();
    void writeBoolean(boolean b);

    char readChar();
    void writeChar(char c);

    short readUByte();
    void writeUByte(short ub);

    short readShort();
    void writeShort(short s);

    int readUShort();
    void writeUShort(int us);

    int readInt();
    void writeInt(int i);

    long readUInt();
    void writeUInt(long uint);

    long readLong();
    void writeLong(long ui);

    BigInteger readULong();
    void writeULong(BigInteger ul);

    float readFloat();
    void writeFloat(float f);

    double readDouble();
    void writeDouble(double d);

    String readString();
    String readString(int length);
    void writeString(String s);
}

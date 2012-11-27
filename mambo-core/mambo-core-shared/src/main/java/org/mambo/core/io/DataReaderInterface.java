package org.mambo.core.io;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 18:44
 */
public interface DataReaderInterface {
    int getOffset();
    void setOffset(int offset);

    int getRemaining();

    byte readByte();
    short readUnsignedByte();

    byte[] readBytes(int n);

    short readShort();
    int readUnsignedShort();

    int readInt();
    long readUnsignedInt();

    long readLong();
    BigInteger readUnsignedLong();

    double readDouble();
    float readFloat();

    char readChar();

    boolean readBoolean();

    String readString();
}

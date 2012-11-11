package org.mambo.protocol.client.io;

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

    char readChar();

    boolean readBoolean();

    String readString();
}

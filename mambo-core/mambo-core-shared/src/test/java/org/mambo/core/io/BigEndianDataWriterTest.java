package org.mambo.core.io;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 21:23
 */
public class BigEndianDataWriterTest {
    @Test
    public void writeByte() {
        DataWriterInterface writer = new BigEndianDataWriter(1);
        writer.writeByte((byte) 5);

        assertEquals(1, writer.getLength());
        assertEquals(5, new BigEndianDataReader(writer.getData()).readByte());
    }

    @Test
    public void writeUnsignedByte() {
        DataWriterInterface writer = new BigEndianDataWriter(1);
        writer.writeUnsignedByte((short) 255);

        assertEquals(1, writer.getLength());
        assertEquals(255, new BigEndianDataReader(writer.getData()).readUnsignedByte());
        assertEquals(-1, new BigEndianDataReader(writer.getData()).readByte());
    }

    @Test
    public void writeBytes() {
        DataWriterInterface writer = new BigEndianDataWriter(2);
        writer.writeBytes(new byte[] {-1, -1});

        assertEquals(2, writer.getLength());
        assertEquals(2, writer.getOffset());

        assertEquals(255, new BigEndianDataReader(writer.getData()).readUnsignedShort());
    }

    @Test
    public void writeShort() {
        DataWriterInterface writer = new BigEndianDataWriter(2);
        writer.writeShort((short) 15321);

        assertEquals(2, writer.getLength());
        assertEquals(15321, new BigEndianDataReader(writer.getData()).readShort());
    }

    @Test
    public void writeUnsignedShort() {
        DataWriterInterface writer = new BigEndianDataWriter(2);
        writer.writeUnsignedShort(65535);

        assertEquals(2, writer.getLength());
        assertEquals(65535, new BigEndianDataReader(writer.getData()).readUnsignedShort());
        assertEquals(-1, new BigEndianDataReader(writer.getData()).readShort());
    }

    @Test
    public void writeInt() {
        DataWriterInterface writer = new BigEndianDataWriter(4);
        writer.writeInt(564878121);

        assertEquals(4, writer.getLength());
        assertEquals(564878121, new BigEndianDataReader(writer.getData()).readInt());
    }

    @Test
    public void writeUnsignedInt() {
        DataWriterInterface writer = new BigEndianDataWriter(4);
        writer.writeUnsignedInt(4294967295L);

        assertEquals(4, writer.getLength());
        assertEquals(4294967295L, new BigEndianDataReader(writer.getData()).readUnsignedInt());
        assertEquals(-1, new BigEndianDataReader(writer.getData()).readInt());
    }

    @Test
    public void writeLong() {
        DataWriterInterface writer = new BigEndianDataWriter(8);
        writer.writeLong(2165878798756154871L);

        assertEquals(writer.getLength(), 8);
        assertEquals(2165878798756154871L, new BigEndianDataReader(writer.getData()).readLong());
    }

    @Test
    public void writeUnsignedLong() {
        DataWriterInterface writer = new BigEndianDataWriter(8);
        writer.writeUnsignedLong(new BigInteger("18446744073709551615"));

        assertEquals(8, writer.getLength());
        assertEquals(new BigInteger("18446744073709551615"), new BigEndianDataReader(writer.getData()).readUnsignedLong());
        assertEquals(-1, new BigEndianDataReader(writer.getData()).readLong());
    }

    @Test
    public void writeDouble() {
        DataWriterInterface writer = new BigEndianDataWriter(8);
        writer.writeDouble(3.14);

        assertEquals(8, writer.getLength());
        assertEquals(3.14, new BigEndianDataReader(writer.getData()).readDouble());
    }

    @Test
    public void writeFloat() {
        DataWriterInterface writer = new BigEndianDataWriter(4);
        writer.writeFloat(3.14F);

        assertEquals(4, writer.getLength());
        assertEquals(3.14F, new BigEndianDataReader(writer.getData()).readFloat());
    }

    @Test
    public void writeChar() {
        DataWriterInterface writer = new BigEndianDataWriter(1);
        writer.writeChar('a');

        assertEquals(1, writer.getLength());
        assertEquals('a', new BigEndianDataReader(writer.getData()).readChar());
    }

    @Test
    public void writeBoolean() {
        DataWriterInterface writer = new BigEndianDataWriter(1);
        writer.writeBoolean(true);

        assertEquals(1, writer.getLength());
        assertTrue(new BigEndianDataReader(writer.getData()).readBoolean());

        writer.setOffset(0);
        writer.writeBoolean(false);

        assertEquals(1, writer.getLength());
        assertFalse(new BigEndianDataReader(writer.getData()).readBoolean());
    }

    @Test
    public void writeString() {
        DataWriterInterface writer = new BigEndianDataWriter(5);
        writer.writeString("abc");

        assertEquals(5, writer.getLength());
        assertEquals("abc", new BigEndianDataReader(writer.getData()).readString());
    }

    @Test
    public void shiftRight() {
        DataWriterInterface writer = new BigEndianDataWriter(2);

        writer.writeByte((byte) 1);

        DataReaderInterface reader = new BigEndianDataReader(writer.getData());
        assertEquals(1, reader.readByte());

        writer.setOffset(0); // return to start
        writer.shiftRight(1); // move all bytes to the right
        writer.setOffset(2); // go to end

        assertEquals(3, writer.getLength());

        reader = new BigEndianDataReader(writer.getData());
        assertEquals(0, reader.readByte());
        assertEquals(1, reader.readByte());
    }

    @Test
    public void shiftLeft() {
        DataWriterInterface writer = new BigEndianDataWriter(2);

        writer.writeBytes(new byte[] {0, 1});

        DataReaderInterface reader = new BigEndianDataReader(writer.getData());
        assertEquals(0, reader.readByte());
        assertEquals(1, reader.readByte());

        writer.shiftLeft(1);

        reader = new BigEndianDataReader(writer.getData());
        assertEquals(1, reader.readByte());
    }
}

package org.mambo.core.io;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 19:13
 */
public class BigEndianDataReaderTest {
    @Test
    public void readByte() {
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 55 });

        assertEquals(55, reader.readByte());
    }

    @Test
    public void readUnsignedByte() {
        // unsigned 244 = 1111 0100
        // signed 1111 0100 = -12
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { -12 });

        assertEquals(244, reader.readUnsignedByte());

        reader.setOffset(0);
        assertEquals(-12, reader.readByte());
    }

    @Test
    public void readShort() {
        // 10025 = 0010 0111 0010 1001
        // 0010 0111 = 39
        // 0010 1001 = 41
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 39, 41 });

        assertEquals(10025, reader.readShort());
    }

    @Test
    public void readUnsignedShort() {
        // unsigned 65535 = 1111 1111 1111 1111
        // signed 1111 1111 1111 1111 = -1
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { -1, -1 });

        assertEquals(65535, reader.readUnsignedShort());

        reader.setOffset(0);
        assertEquals(-1, reader.readShort());
    }

    @Test
    public void readInt() {
        // 9785314 = 0000 0000 1001 0101 0100 1111 1110 0010

        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 0, -107, 79, -30 });

        assertEquals(9785314, reader.readInt());
    }

    @Test
    public void readUnsignedInt() {
        // unsigned 4294967295 = 1111 1111 1111 1111 1111 1111 1111 1111
        // signed 1111 1111 1111 1111 1111 1111 1111 1111 = -1

        DataReaderInterface reader = new BigEndianDataReader(new byte[] {-1, -1, -1, -1});

        assertEquals(4294967295L, reader.readUnsignedInt());

        reader.setOffset(0);
        assertEquals(-1, reader.readInt());
    }

    @Test
    public void readLong() {
        // 645987654187165 = 0000 0000 0000 0010 0100 1011 1000 0101 1011 1000 1010 1000 0011 1000 1001 1101
        DataReaderInterface reader = new BigEndianDataReader(new byte[] {0, 2, 75, -123, -72, -88, 56, -99});

        assertEquals(645987654187165L, reader.readLong());
    }

    @Test
    public void readUnsignedLong() {
        BigInteger expected = new BigInteger("18446744073709551615");

        DataReaderInterface reader = new BigEndianDataReader(new byte[] {-1, -1, -1, -1, -1, -1, -1, -1});

        assertEquals(expected, reader.readUnsignedLong());

        reader.setOffset(0);
        assertEquals(-1, reader.readLong());
    }

    @Test
    public void readDouble() {
        byte[] bytes = ByteBuffer.allocate(8).putDouble(3.14).array();
        DataReaderInterface reader = new BigEndianDataReader(bytes);

        assertEquals(3.14, reader.readDouble());
    }

    @Test
    public void readFloat() {
        byte[] bytes = ByteBuffer.allocate(4).putFloat(3.14F).array();
        DataReaderInterface reader = new BigEndianDataReader(bytes);

        assertEquals(3.14F, reader.readFloat());
    }

    @Test
    public void readChar() {
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 97 });
        assertEquals('a', reader.readChar());
    }

    @Test
    public void readBoolean() {
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 1 });
        assertTrue(reader.readBoolean());
        reader = new BigEndianDataReader(new byte[] { 0 });
        assertFalse(reader.readBoolean());
    }

    @Test
    public void readString() {
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 0, 2, 97, 98, 100 });
        assertEquals("ab", reader.readString());
    }
    @Test
    public void remaining() {
        DataReaderInterface reader = new BigEndianDataReader(new byte[] { 0, 2, 97, 98, 100 });
        reader.readShort();

        assertEquals(3, reader.getRemaining());
    }
}

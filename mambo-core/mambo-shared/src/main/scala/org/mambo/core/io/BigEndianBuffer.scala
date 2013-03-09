package org.mambo.core.io

import java.nio.charset.Charset
import java.nio.{CharBuffer, ByteBuffer}

/**
 * @author Blackrush
 */
class BigEndianBuffer(private var buf: Array[Byte], var offset: Int = 0) extends Buffer {
  import BigEndianBuffer._

  private def grow(n: Int) {
    val newBuf = Array.ofDim[Byte](buf.length + n * 2)
    Array.copy(buf, 0, newBuf, 0, buf.length)

    buf = newBuf
  }

  private def ensure(n: Int) {
    if (offset + n > buf.length) grow(n)
  }

  private def append(byte: Byte) {
    buf(offset) = byte
    offset += 1
  }

  def data = compact().rawData

  def rawData = buf

  def remaining = buf.length - offset

  def compact() = {
    val newBuf = Array.ofDim[Byte](offset + 1)
    Array.copy(buf, 0, newBuf, 0, offset + 1)
    new BigEndianBuffer(newBuf, 0)
  }

  def shiftLeft(length: Int) {
    Array.copy(buf, length, buf, 0, buf.length - length)

    var i = buf.length - length
    while (i < buf.length) {
      buf(i) = 0.toByte
      i += 1
    }
  }

  def shiftRight(length: Int) {
    if (remaining < length) {
      val newBuf = Array.ofDim[Byte](buf.length + length)
      Array.copy(buf, 0, newBuf, length, offset + 1)
      buf = newBuf
    } else {
      Array.copy(buf, 0, buf, length, offset + 1)
    }
  }

  def readBytes() = readBytes(readShort())

  def readBytes(length: Int) = (0 to length).map { _ => readByte() }.toArray

  def writeBytes(bytes: Array[Byte]) = writeBytes(bytes, 0, bytes.length)

  def writeBytes(bytes: Array[Byte], offset: Int, length: Int) {
    ensure(length)
    Array.copy(bytes, offset, buf, this.offset, length)
    this.offset += length
  }

  def writeArray(bytes: Array[Byte]) = writeArray(bytes, 0, bytes.length)

  def writeArray(bytes: Array[Byte], offset: Int, length: Int) {
    ensure(2 + length)
    writeUShort(length)
    Array.copy(bytes, offset, this.buf, this.offset, length)
    this.offset += length
  }

  def readByte() = {
    val byte = buf(offset)
    offset += 1
    byte
  }

  def writeByte(byte: Byte) {
    ensure(1)
    append(byte)
  }

  def readBoolean() = readByte() == 1

  def writeBoolean(boolean: Boolean) = if (boolean) writeByte(1) else writeByte(0)

  def readUByte() = (readByte() & 0xFF).toShort

  def writeUByte(ubyte: UByte) = writeByte((ubyte & 0xFF).toByte)

  def readChar() = {
    val char = charset.decode(ByteBuffer.wrap(buf, offset, charLength)).charAt(0)
    offset += charLength
    char
  }

  def writeChar(char: Char) {
    ensure(charLength)
    charset.encode(CharBuffer.wrap(Array(char))).array() foreach append
  }

  def readShort() = (readUByte() << 8 | readUByte()).toShort

  def writeShort(short: Short) {
    ensure(2)
    append((short >> 8).toByte)
    append((short & 0xFF).toByte)
  }

  def readUShort() = readUByte() << 8 | readUByte()

  def writeUShort(ushort: UShort) {
    ensure(2)
    append((ushort >> 8).toByte)
    append((ushort & 0xFF).toByte)
  }

  def readInt() = readUShort() << 16 | readUShort()

  def writeInt(int: Int) {
    ensure(4)
    append((int >> 24       ).toByte)
    append((int >> 16 & 0xFF).toByte)
    append((int >> 8  & 0xFF).toByte)
    append((int       & 0xFF).toByte)
  }

  def readUInt() = readUShort().toLong << 16 | readUShort()

  def writeUInt(uint: UInt) {
    ensure(4)
    append((uint >> 24       ).toByte)
    append((uint >> 16 & 0xFF).toByte)
    append((uint >> 8  & 0xFF).toByte)
    append((uint       & 0xFF).toByte)
  }

  def readLong() = readUInt() << 32 | readUInt()

  def writeLong(long: Long) {
    ensure(8)
    append((long >> 56 & 0xFF).toByte)
    append((long >> 48 & 0xFF).toByte)
    append((long >> 40 & 0xFF).toByte)
    append((long >> 32 & 0xFF).toByte)
    append((long >> 24 & 0xFF).toByte)
    append((long >> 16 & 0xFF).toByte)
    append((long >> 8  & 0xFF).toByte)
    append((long       & 0xFF).toByte)
  }

  def readULong() = BigInt(readUInt()) << 32 | BigInt(readUInt())

  def writeULong(ulong: ULong) {
    ensure(8)
    append((ulong >> 56 & 0xFF).toByte)
    append((ulong >> 48 & 0xFF).toByte)
    append((ulong >> 40 & 0xFF).toByte)
    append((ulong >> 32 & 0xFF).toByte)
    append((ulong >> 24 & 0xFF).toByte)
    append((ulong >> 16 & 0xFF).toByte)
    append((ulong >> 8  & 0xFF).toByte)
    append((ulong       & 0xFF).toByte)
  }

  def readFloat() = java.lang.Float.intBitsToFloat(readInt())

  def writeFloat(float: Float) = writeInt(java.lang.Float.floatToIntBits(float))

  def readDouble() = java.lang.Double.longBitsToDouble(readLong())

  def writeDouble(double: Double) = writeLong(java.lang.Double.doubleToLongBits(double))

  def readString() = readString(readUShort())

  def readString(length: Int) = (0 to length - 1).map { _ => readChar() }.mkString

  def writeString(string: String) = writeArray(charset.encode(string).array())
}

object BigEndianBuffer {
  val charset = Charset.forName("UTF-8")
  val charLength = 1
}

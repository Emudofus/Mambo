package org.mambo.core.io

import java.nio.ByteBuffer

/**
 * @author Blackrush
 */
trait Buffer {
  type UByte = Short
  type UShort = Int
  type UInt = Long
  type ULong = BigInt

  var offset: Int

  def data: Array[Byte]
  def rawData: Array[Byte]
  def remaining: Int

  def compact(): Buffer
  def toByteBuffer = ByteBuffer.wrap(rawData)

  def shiftLeft(length: Int)
  def shiftRight(length: Int)

  def readBytes(): Array[Byte]
  def readBytes(length: Int): Array[Byte]
  def writeBytes(bytes: Array[Byte])
  def writeBytes(bytes: Array[Byte], offset: Int, length: Int)

  def writeArray(bytes: Array[Byte])
  def writeArray(bytes: Array[Byte], offset: Int, length: Int)

  def readByte(): Byte
  def writeByte(byte: Byte)

  def readBoolean(): Boolean
  def writeBoolean(boolean: Boolean)

  def readUByte(): UByte
  def writeUByte(ubyte: UByte)

  def readChar(): Char
  def writeChar(char: Char)

  def readShort(): Short
  def writeShort(short: Short)

  def readUShort(): UShort
  def writeUShort(ushort: UShort)

  def readInt(): Int
  def writeInt(int: Int)

  def readUInt(): UInt
  def writeUInt(uint: UInt)

  def readLong(): Long
  def writeLong(long: Long)

  def readULong(): ULong
  def writeULong(ulong: ULong)

  def readFloat(): Float
  def writeFloat(float: Float)

  def readDouble(): Double
  def writeDouble(double: Double)

  def readString(): String
  def readString(length: Int): String
  def writeString(string: String)
}

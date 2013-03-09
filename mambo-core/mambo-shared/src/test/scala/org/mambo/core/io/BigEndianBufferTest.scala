package org.mambo.core.io

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * @author Blackrush
 */
class BigEndianBufferTest extends WordSpec with ShouldMatchers {
  def sample(n: Int) = new BigEndianBuffer(sampleBytes(n))
  def sample(bytes: Byte*) = new BigEndianBuffer(bytes.toArray)
  def sampleBytes(n: Int) = Array.range(0, n).map(_.toByte)

  "A big-endian buffer" should {
    "returns same reference" in {
      val array = Array.empty[Byte]
      val buffer = new BigEndianBuffer(array)

      buffer.rawData should be.theSameInstanceAs(array)
    }

    "compute valid remaining bytes number" in {
      val n = 10

      val buffer = sample(n)
      buffer.remaining should be(n)
    }

    "have a valid offset" in {
      val buffer = sample(10)

      buffer.readDouble()

      buffer.offset should be(8) // was 0 but read 8 bytes
    }

    "properly compact data" in {
      val buffer = sample(100)
      buffer.offset = 50

      val compacted = buffer.compact()
      compacted.remaining should be(51)

      val compactedData = compacted.rawData
      compactedData should have.length(51)

      val otherCompactedData = buffer.data
      otherCompactedData should equal(compactedData)
    }

    "read a byte" in {
      val buffer = sample(1, 2, 3, 4)

      buffer.readByte() should be(1)
      buffer.readByte() should be(2)
      buffer.readByte() should be(3)
      buffer.readByte() should be(4)
    }

    "write a byte" in {
      val buffer = sample(1)
      buffer.writeByte(127)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(127)
    }

    "read an unsigned byte" in {
      val buffer = sample(-1, -1)

      buffer.readUByte() should be(255)
    }

    "write an unsigned byte" in {
      val buffer = sample(1)
      buffer.writeUByte(255.toShort)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(-1)
    }

    "read a short" in {
      val buffer = sample(1, 2, 3, 4)

      buffer.readShort() should be(258)
      buffer.readShort() should be(772)
    }

    "write a short" in {
      val buffer = sample(4)
      buffer.writeShort(258)
      buffer.writeShort(772)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(1)
      data(1) should be(2)
      data(2) should be(3)
      data(3) should be(4)
    }

    "read an unsigned short" in {
      val buffer = sample(-1, -1)

      buffer.readUShort() should be(65535)
    }

    "write an unsigned short" in {
      val buffer = sample(2)
      buffer.writeUShort(65535)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(-1)
      data(1) should be(-1)
    }

    "read an int" in {
      val buffer = sample(1, 2, 3, 4)

      buffer.readInt() should be(16909060)
    }

    "write an int" in {
      val buffer = sample(4)
      buffer.writeInt(16909060)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(1)
      data(1) should be(2)
      data(2) should be(3)
      data(3) should be(4)
    }

    "read an unsigned int" in {
      val buffer = sample(-1, -1, -1, -1)

      buffer.readUInt() should be(4294967295L)
    }

    "write an unsigned int" in {
      val buffer = sample(4)
      buffer.writeUInt(4294967295L)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(-1)
      data(1) should be(-1)
      data(2) should be(-1)
      data(3) should be(-1)
    }

    "read a long" in {
      val buffer = sample(1, 2, 3, 4, 5, 6, 7, 8)

      buffer.readLong() should be(72623859790382856L)
    }

    "write a long" in {
      val buffer = sample(8)
      buffer.writeLong(72623859790382856L)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(1)
      data(1) should be(2)
      data(2) should be(3)
      data(3) should be(4)
      data(4) should be(5)
      data(5) should be(6)
      data(6) should be(7)
      data(7) should be(8)
    }

    "read an unsigned long" in {
      val buffer = sample(-1, -1, -1, -1, -1, -1, -1, -1)
      buffer.readULong() should be(BigInt("18446744073709551615"))
    }

    "write an unsigned long" in {
      val buffer = sample(8)
      buffer.writeULong(BigInt("18446744073709551615"))
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(-1)
      data(1) should be(-1)
      data(2) should be(-1)
      data(3) should be(-1)
      data(4) should be(-1)
      data(5) should be(-1)
      data(6) should be(-1)
      data(7) should be(-1)
    }

    "read a float" in {
      val buffer = sample(0x3F.toByte, 0x80.toByte, 0.toByte, 0.toByte)
      buffer.readFloat() should be(1.0f)
    }

    "write a float" in {
      val buffer = sample(4)
      buffer.writeFloat(1.0f)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(0x3F.toByte)
      data(1) should be(0x80.toByte)
      data(2) should be(0)
      data(3) should be(0)
    }

    "read a double" in {
      val buffer = sample(0x3F.toByte, 0xF0.toByte, 0.toByte, 0.toByte, 0.toByte, 0.toByte, 0.toByte, 0.toByte)
      buffer.readDouble() should be(1.0)
    }

    "write a double" in {
      val buffer = sample(8)
      buffer.writeDouble(1.0)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(0x3F.toByte)
      data(1) should be(0xF0.toByte)
      data(2) should be(0)
      data(3) should be(0)
      data(4) should be(0)
      data(5) should be(0)
      data(6) should be(0)
      data(7) should be(0)
    }

    "read a boolean" in {
      val buffer = sample(0, 1)
      buffer.readBoolean() should be(false)
      buffer.readBoolean() should be(true)
    }

    "write a boolean" in {
      val buffer = sample(2)
      buffer.writeBoolean(false)
      buffer.writeBoolean(true)
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(0)
      data(1) should be(1)
    }

    "read a string" in {
      sample('a'.toByte, 'b'.toByte, 'c'.toByte).readString(3) should be("abc")
      sample(0, 3, 'a'.toByte, 'b'.toByte, 'c'.toByte).readString() should be("abc")
    }

    "write a string" in {
      val buffer = sample(5)
      buffer.writeString("abc")
      buffer.remaining should be(0)

      val data = buffer.rawData
      data(0) should be(0)
      data(1) should be(3)
      data(2) should be('a'.toByte)
      data(3) should be('b'.toByte)
      data(4) should be('c'.toByte)
    }

    "shift to left" in {
      val buffer = sample(1, 2, 3, 4, 5)
      buffer.shiftLeft(2)

      val data = buffer.rawData
      data should have length(5)
      data(0) should be(3)
      data(1) should be(4)
      data(2) should be(5)
      data(3) should be(0)
      data(4) should be(0)
    }

    "shift to right" in {
      val buffer = sample(1, 2, 3, 4, 5)
      buffer.offset = 4
      buffer.shiftRight(2)

      val data = buffer.rawData
      data should have length(7)
      data(0) should be(0)
      data(1) should be(0)
      data(2) should be(1)
      data(3) should be(2)
      data(4) should be(3)
      data(5) should be(4)
      data(6) should be(5)
    }
  }
}

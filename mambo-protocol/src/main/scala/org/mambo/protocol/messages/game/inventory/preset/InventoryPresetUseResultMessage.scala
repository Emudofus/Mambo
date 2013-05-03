




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetUseResultMessage extends MessageDeserializer {
  val messageId = 6163

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetUseResultMessage.messageId

    val presetId: Byte
    val code: Byte
    val unlinkedPosition: Seq[UByte]

    def serialize(buf: Buffer) {
      buf.writeByte(presetId)
      buf.writeByte(code)
      buf.writeUShort(unlinkedPosition.length)
      for (entry <- unlinkedPosition) {
        buf.writeUByte(entry)
      }
    }

  }

  protected def create(presetId: Byte, code: Byte, unlinkedPosition: Seq[UByte]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val presetId = buf.readByte()
    val code = buf.readByte()
    val unlinkedPosition = {
      val builder = collection.immutable.Seq.newBuilder[UByte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readUByte()
      }
      builder.result()
    }

    create(presetId, code, unlinkedPosition)
  }

}

object InventoryPresetUseResultMessage extends InventoryPresetUseResultMessage {
  case class MessageImpl(presetId: Byte, code: Byte, unlinkedPosition: Seq[UByte]) extends Message
  type Target = MessageImpl

  override def create(presetId: Byte, code: Byte, unlinkedPosition: Seq[UByte]) = MessageImpl(presetId, code, unlinkedPosition)

  def apply(presetId: Byte, code: Byte, unlinkedPosition: Seq[UByte]) = create(presetId, code, unlinkedPosition)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


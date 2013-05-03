




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetSaveResultMessage extends MessageDeserializer {
  val messageId = 6170

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetSaveResultMessage.messageId

    val presetId: Byte
    val code: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(presetId)
      buf.writeByte(code)
    }

  }

  protected def create(presetId: Byte, code: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val presetId = buf.readByte()
    val code = buf.readByte()

    create(presetId, code)
  }

}

object InventoryPresetSaveResultMessage extends InventoryPresetSaveResultMessage {
  case class MessageImpl(presetId: Byte, code: Byte) extends Message
  type Target = MessageImpl

  override def create(presetId: Byte, code: Byte) = MessageImpl(presetId, code)

  def apply(presetId: Byte, code: Byte) = create(presetId, code)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


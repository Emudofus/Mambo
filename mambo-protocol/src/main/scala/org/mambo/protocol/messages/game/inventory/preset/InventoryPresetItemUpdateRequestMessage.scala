




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetItemUpdateRequestMessage extends MessageDeserializer {
  val messageId = 6210

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetItemUpdateRequestMessage.messageId

    val presetId: Byte
    val position: UByte
    val objUid: Int

    def serialize(buf: Buffer) {
      buf.writeByte(presetId)
      buf.writeUByte(position)
      buf.writeInt(objUid)
    }

  }

  protected def create(presetId: Byte, position: UByte, objUid: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val presetId = buf.readByte()
    val position = buf.readUByte()
    val objUid = buf.readInt()

    create(presetId, position, objUid)
  }

}

object InventoryPresetItemUpdateRequestMessage extends InventoryPresetItemUpdateRequestMessage {
  case class MessageImpl(presetId: Byte, position: UByte, objUid: Int) extends Message
  type Target = MessageImpl

  override def create(presetId: Byte, position: UByte, objUid: Int) = MessageImpl(presetId, position, objUid)

  def apply(presetId: Byte, position: UByte, objUid: Int) = create(presetId, position, objUid)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


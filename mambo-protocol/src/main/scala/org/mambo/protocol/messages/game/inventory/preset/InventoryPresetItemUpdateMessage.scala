




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetItemUpdateMessage extends MessageDeserializer {
  val messageId = 6168

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetItemUpdateMessage.messageId

    val presetId: Byte
    val presetItem: PresetItem.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeByte(presetId)
      presetItem.serialize(buf)
    }

  }

  protected def create(presetId: Byte, presetItem: PresetItem.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val presetId = buf.readByte()
    val presetItem = PresetItem.deserialize(buf)

    create(presetId, presetItem)
  }

}

object InventoryPresetItemUpdateMessage extends InventoryPresetItemUpdateMessage {
  case class MessageImpl(presetId: Byte, presetItem: PresetItem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(presetId: Byte, presetItem: PresetItem.TypeImpl) = MessageImpl(presetId, presetItem)

  def apply(presetId: Byte, presetItem: PresetItem.TypeImpl) = create(presetId, presetItem)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetSaveMessage extends MessageDeserializer {
  val messageId = 6165

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetSaveMessage.messageId

    val presetId: Byte
    val symbolId: Byte
    val saveEquipment: Boolean

    def serialize(buf: Buffer) {
      buf.writeByte(presetId)
      buf.writeByte(symbolId)
      buf.writeBoolean(saveEquipment)
    }

  }

  protected def create(presetId: Byte, symbolId: Byte, saveEquipment: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val presetId = buf.readByte()
    val symbolId = buf.readByte()
    val saveEquipment = buf.readBoolean()

    create(presetId, symbolId, saveEquipment)
  }

}

object InventoryPresetSaveMessage extends InventoryPresetSaveMessage {
  case class MessageImpl(presetId: Byte, symbolId: Byte, saveEquipment: Boolean) extends Message
  type Target = MessageImpl

  override def create(presetId: Byte, symbolId: Byte, saveEquipment: Boolean) = MessageImpl(presetId, symbolId, saveEquipment)

  def apply(presetId: Byte, symbolId: Byte, saveEquipment: Boolean) = create(presetId, symbolId, saveEquipment)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


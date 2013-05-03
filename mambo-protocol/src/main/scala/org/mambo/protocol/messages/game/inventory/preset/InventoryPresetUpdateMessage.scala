




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetUpdateMessage extends MessageDeserializer {
  val messageId = 6171

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetUpdateMessage.messageId

    val preset: Preset.TypeImpl

    def serialize(buf: Buffer) {
      preset.serialize(buf)
    }

  }

  protected def create(preset: Preset.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val preset = Preset.deserialize(buf)

    create(preset)
  }

}

object InventoryPresetUpdateMessage extends InventoryPresetUpdateMessage {
  case class MessageImpl(preset: Preset.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(preset: Preset.TypeImpl) = MessageImpl(preset)

  def apply(preset: Preset.TypeImpl) = create(preset)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


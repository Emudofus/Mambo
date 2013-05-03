




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryContentAndPresetMessage extends InventoryContentMessage {
  override val messageId = 6162

  protected trait Message extends InventoryContentMessage.Message with Serializable {
    override val messageId = InventoryContentAndPresetMessage.messageId

    val presets: Seq[Preset.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(presets.length)
      for (entry <- presets) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(objects: Seq[ObjectItem.TypeImpl], kamas: Int, presets: Seq[Preset.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }
    val kamas = buf.readInt()
    val presets = {
      val builder = collection.immutable.Seq.newBuilder[Preset.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += Preset.deserialize(buf)
      }
      builder.result()
    }

    create(objects, kamas, presets)
  }

}

object InventoryContentAndPresetMessage extends InventoryContentAndPresetMessage {
  case class MessageImpl(objects: Seq[ObjectItem.TypeImpl], kamas: Int, presets: Seq[Preset.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(objects: Seq[ObjectItem.TypeImpl], kamas: Int, presets: Seq[Preset.TypeImpl]) = MessageImpl(objects, kamas, presets)

  def apply(objects: Seq[ObjectItem.TypeImpl], kamas: Int, presets: Seq[Preset.TypeImpl]) = create(objects, kamas, presets)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShortcutBarContentMessage extends MessageDeserializer {
  val messageId = 6231

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ShortcutBarContentMessage.messageId

    val barType: Byte
    val shortcuts: Seq[Shortcut.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeByte(barType)
      buf.writeUShort(shortcuts.length)
      for (entry <- shortcuts) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(barType: Byte, shortcuts: Seq[Shortcut.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val barType = buf.readByte()
    val shortcuts = {
      val builder = collection.immutable.Seq.newBuilder[Shortcut.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[Shortcut.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(barType, shortcuts)
  }

}

object ShortcutBarContentMessage extends ShortcutBarContentMessage {
  case class MessageImpl(barType: Byte, shortcuts: Seq[Shortcut.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(barType: Byte, shortcuts: Seq[Shortcut.TypeImpl]) = MessageImpl(barType, shortcuts)

  def apply(barType: Byte, shortcuts: Seq[Shortcut.TypeImpl]) = create(barType, shortcuts)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


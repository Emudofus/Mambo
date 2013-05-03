




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShortcutBarAddRequestMessage extends MessageDeserializer {
  val messageId = 6225

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ShortcutBarAddRequestMessage.messageId

    val barType: Byte
    val shortcut: Shortcut.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeByte(barType)
      buf.writeUShort(shortcut.typeId)
      shortcut.serialize(buf)
    }

  }

  protected def create(barType: Byte, shortcut: Shortcut.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val barType = buf.readByte()
    val shortcut = types.get[Shortcut.TypeImpl](buf.readShort());

    create(barType, shortcut)
  }

}

object ShortcutBarAddRequestMessage extends ShortcutBarAddRequestMessage {
  case class MessageImpl(barType: Byte, shortcut: Shortcut.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(barType: Byte, shortcut: Shortcut.TypeImpl) = MessageImpl(barType, shortcut)

  def apply(barType: Byte, shortcut: Shortcut.TypeImpl) = create(barType, shortcut)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


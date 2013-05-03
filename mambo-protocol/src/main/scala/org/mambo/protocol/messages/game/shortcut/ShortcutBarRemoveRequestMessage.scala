




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShortcutBarRemoveRequestMessage extends MessageDeserializer {
  val messageId = 6228

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ShortcutBarRemoveRequestMessage.messageId

    val barType: Byte
    val slot: Int

    def serialize(buf: Buffer) {
      buf.writeByte(barType)
      buf.writeInt(slot)
    }

  }

  protected def create(barType: Byte, slot: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val barType = buf.readByte()
    val slot = buf.readInt()

    create(barType, slot)
  }

}

object ShortcutBarRemoveRequestMessage extends ShortcutBarRemoveRequestMessage {
  case class MessageImpl(barType: Byte, slot: Int) extends Message
  type Target = MessageImpl

  override def create(barType: Byte, slot: Int) = MessageImpl(barType, slot)

  def apply(barType: Byte, slot: Int) = create(barType, slot)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


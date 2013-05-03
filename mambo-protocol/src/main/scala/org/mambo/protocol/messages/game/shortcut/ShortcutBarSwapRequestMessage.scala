




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShortcutBarSwapRequestMessage extends MessageDeserializer {
  val messageId = 6230

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ShortcutBarSwapRequestMessage.messageId

    val barType: Byte
    val firstSlot: Int
    val secondSlot: Int

    def serialize(buf: Buffer) {
      buf.writeByte(barType)
      buf.writeInt(firstSlot)
      buf.writeInt(secondSlot)
    }

  }

  protected def create(barType: Byte, firstSlot: Int, secondSlot: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val barType = buf.readByte()
    val firstSlot = buf.readInt()
    val secondSlot = buf.readInt()

    create(barType, firstSlot, secondSlot)
  }

}

object ShortcutBarSwapRequestMessage extends ShortcutBarSwapRequestMessage {
  case class MessageImpl(barType: Byte, firstSlot: Int, secondSlot: Int) extends Message
  type Target = MessageImpl

  override def create(barType: Byte, firstSlot: Int, secondSlot: Int) = MessageImpl(barType, firstSlot, secondSlot)

  def apply(barType: Byte, firstSlot: Int, secondSlot: Int) = create(barType, firstSlot, secondSlot)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


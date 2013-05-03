




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeCraftSlotCountIncreasedMessage extends MessageDeserializer {
  val messageId = 6125

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeCraftSlotCountIncreasedMessage.messageId

    val newMaxSlot: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(newMaxSlot)
    }

  }

  protected def create(newMaxSlot: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val newMaxSlot = buf.readByte()

    create(newMaxSlot)
  }

}

object ExchangeCraftSlotCountIncreasedMessage extends ExchangeCraftSlotCountIncreasedMessage {
  case class MessageImpl(newMaxSlot: Byte) extends Message
  type Target = MessageImpl

  override def create(newMaxSlot: Byte) = MessageImpl(newMaxSlot)

  def apply(newMaxSlot: Byte) = create(newMaxSlot)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


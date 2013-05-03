




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangePlayerMultiCraftRequestMessage extends ExchangeRequestMessage {
  override val messageId = 5784

  protected trait Message extends ExchangeRequestMessage.Message with Serializable {
    override val messageId = ExchangePlayerMultiCraftRequestMessage.messageId

    val target: Int
    val skillId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(target)
      buf.writeInt(skillId)
    }

  }

  protected def create(exchangeType: Byte, target: Int, skillId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val exchangeType = buf.readByte()
    val target = buf.readInt()
    val skillId = buf.readInt()

    create(exchangeType, target, skillId)
  }

}

object ExchangePlayerMultiCraftRequestMessage extends ExchangePlayerMultiCraftRequestMessage {
  case class MessageImpl(exchangeType: Byte, target: Int, skillId: Int) extends Message
  type Target = MessageImpl

  override def create(exchangeType: Byte, target: Int, skillId: Int) = MessageImpl(exchangeType, target, skillId)

  def apply(exchangeType: Byte, target: Int, skillId: Int) = create(exchangeType, target, skillId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


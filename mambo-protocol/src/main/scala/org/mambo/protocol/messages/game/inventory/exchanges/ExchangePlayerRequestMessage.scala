




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangePlayerRequestMessage extends ExchangeRequestMessage {
  override val messageId = 5773

  protected trait Message extends ExchangeRequestMessage.Message with Serializable {
    override val messageId = ExchangePlayerRequestMessage.messageId

    val target: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(target)
    }

  }

  protected def create(exchangeType: Byte, target: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val exchangeType = buf.readByte()
    val target = buf.readInt()

    create(exchangeType, target)
  }

}

object ExchangePlayerRequestMessage extends ExchangePlayerRequestMessage {
  case class MessageImpl(exchangeType: Byte, target: Int) extends Message
  type Target = MessageImpl

  override def create(exchangeType: Byte, target: Int) = MessageImpl(exchangeType, target)

  def apply(exchangeType: Byte, target: Int) = create(exchangeType, target)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeRequestedTradeMessage extends ExchangeRequestedMessage {
  override val messageId = 5523

  protected trait Message extends ExchangeRequestedMessage.Message with Serializable {
    override val messageId = ExchangeRequestedTradeMessage.messageId

    val source: Int
    val target: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(source)
      buf.writeInt(target)
    }

  }

  protected def create(exchangeType: Byte, source: Int, target: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val exchangeType = buf.readByte()
    val source = buf.readInt()
    val target = buf.readInt()

    create(exchangeType, source, target)
  }

}

object ExchangeRequestedTradeMessage extends ExchangeRequestedTradeMessage {
  case class MessageImpl(exchangeType: Byte, source: Int, target: Int) extends Message
  type Target = MessageImpl

  override def create(exchangeType: Byte, source: Int, target: Int) = MessageImpl(exchangeType, source, target)

  def apply(exchangeType: Byte, source: Int, target: Int) = create(exchangeType, source, target)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


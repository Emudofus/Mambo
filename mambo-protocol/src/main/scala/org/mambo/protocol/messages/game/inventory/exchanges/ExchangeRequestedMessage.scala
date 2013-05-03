




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeRequestedMessage extends MessageDeserializer {
  val messageId = 5522

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeRequestedMessage.messageId

    val exchangeType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(exchangeType)
    }

  }

  protected def create(exchangeType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val exchangeType = buf.readByte()

    create(exchangeType)
  }

}

object ExchangeRequestedMessage extends ExchangeRequestedMessage {
  case class MessageImpl(exchangeType: Byte) extends Message
  type Target = MessageImpl

  override def create(exchangeType: Byte) = MessageImpl(exchangeType)

  def apply(exchangeType: Byte) = create(exchangeType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


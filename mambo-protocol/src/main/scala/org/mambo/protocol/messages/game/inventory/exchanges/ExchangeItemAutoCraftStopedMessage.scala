




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeItemAutoCraftStopedMessage extends MessageDeserializer {
  val messageId = 5810

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeItemAutoCraftStopedMessage.messageId

    val reason: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(reason)
    }

  }

  protected def create(reason: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val reason = buf.readByte()

    create(reason)
  }

}

object ExchangeItemAutoCraftStopedMessage extends ExchangeItemAutoCraftStopedMessage {
  case class MessageImpl(reason: Byte) extends Message
  type Target = MessageImpl

  override def create(reason: Byte) = MessageImpl(reason)

  def apply(reason: Byte) = create(reason)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


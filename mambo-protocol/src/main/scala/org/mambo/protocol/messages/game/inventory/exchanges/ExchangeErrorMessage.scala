




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeErrorMessage extends MessageDeserializer {
  val messageId = 5513

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeErrorMessage.messageId

    val errorType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(errorType)
    }

  }

  protected def create(errorType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val errorType = buf.readByte()

    create(errorType)
  }

}

object ExchangeErrorMessage extends ExchangeErrorMessage {
  case class MessageImpl(errorType: Byte) extends Message
  type Target = MessageImpl

  override def create(errorType: Byte) = MessageImpl(errorType)

  def apply(errorType: Byte) = create(errorType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


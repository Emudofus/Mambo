




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeClearPaymentForCraftMessage extends MessageDeserializer {
  val messageId = 6145

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeClearPaymentForCraftMessage.messageId

    val paymentType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(paymentType)
    }

  }

  protected def create(paymentType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paymentType = buf.readByte()

    create(paymentType)
  }

}

object ExchangeClearPaymentForCraftMessage extends ExchangeClearPaymentForCraftMessage {
  case class MessageImpl(paymentType: Byte) extends Message
  type Target = MessageImpl

  override def create(paymentType: Byte) = MessageImpl(paymentType)

  def apply(paymentType: Byte) = create(paymentType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


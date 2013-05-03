




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeItemGoldAddAsPaymentMessage extends MessageDeserializer {
  val messageId = 5770

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeItemGoldAddAsPaymentMessage.messageId

    val paymentType: Byte
    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeByte(paymentType)
      buf.writeInt(quantity)
    }

  }

  protected def create(paymentType: Byte, quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paymentType = buf.readByte()
    val quantity = buf.readInt()

    create(paymentType, quantity)
  }

}

object ExchangeItemGoldAddAsPaymentMessage extends ExchangeItemGoldAddAsPaymentMessage {
  case class MessageImpl(paymentType: Byte, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(paymentType: Byte, quantity: Int) = MessageImpl(paymentType, quantity)

  def apply(paymentType: Byte, quantity: Int) = create(paymentType, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


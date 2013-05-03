




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeItemObjectAddAsPaymentMessage extends MessageDeserializer {
  val messageId = 5766

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeItemObjectAddAsPaymentMessage.messageId

    val paymentType: Byte
    val bAdd: Boolean
    val objectToMoveId: Int
    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeByte(paymentType)
      buf.writeBoolean(bAdd)
      buf.writeInt(objectToMoveId)
      buf.writeInt(quantity)
    }

  }

  protected def create(paymentType: Byte, bAdd: Boolean, objectToMoveId: Int, quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paymentType = buf.readByte()
    val bAdd = buf.readBoolean()
    val objectToMoveId = buf.readInt()
    val quantity = buf.readInt()

    create(paymentType, bAdd, objectToMoveId, quantity)
  }

}

object ExchangeItemObjectAddAsPaymentMessage extends ExchangeItemObjectAddAsPaymentMessage {
  case class MessageImpl(paymentType: Byte, bAdd: Boolean, objectToMoveId: Int, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(paymentType: Byte, bAdd: Boolean, objectToMoveId: Int, quantity: Int) = MessageImpl(paymentType, bAdd, objectToMoveId, quantity)

  def apply(paymentType: Byte, bAdd: Boolean, objectToMoveId: Int, quantity: Int) = create(paymentType, bAdd, objectToMoveId, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


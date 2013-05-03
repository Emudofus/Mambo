




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectMovePricedMessage extends ExchangeObjectMoveMessage {
  override val messageId = 5514

  protected trait Message extends ExchangeObjectMoveMessage.Message with Serializable {
    override val messageId = ExchangeObjectMovePricedMessage.messageId

    val price: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(price)
    }

  }

  protected def create(objectUID: Int, quantity: Int, price: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val quantity = buf.readInt()
    val price = buf.readInt()

    create(objectUID, quantity, price)
  }

}

object ExchangeObjectMovePricedMessage extends ExchangeObjectMovePricedMessage {
  case class MessageImpl(objectUID: Int, quantity: Int, price: Int) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, quantity: Int, price: Int) = MessageImpl(objectUID, quantity, price)

  def apply(objectUID: Int, quantity: Int, price: Int) = create(objectUID, quantity, price)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


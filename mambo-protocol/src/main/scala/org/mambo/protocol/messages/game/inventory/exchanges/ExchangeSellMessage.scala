




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeSellMessage extends MessageDeserializer {
  val messageId = 5778

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeSellMessage.messageId

    val objectToSellId: Int
    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objectToSellId)
      buf.writeInt(quantity)
    }

  }

  protected def create(objectToSellId: Int, quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectToSellId = buf.readInt()
    val quantity = buf.readInt()

    create(objectToSellId, quantity)
  }

}

object ExchangeSellMessage extends ExchangeSellMessage {
  case class MessageImpl(objectToSellId: Int, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(objectToSellId: Int, quantity: Int) = MessageImpl(objectToSellId, quantity)

  def apply(objectToSellId: Int, quantity: Int) = create(objectToSellId, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


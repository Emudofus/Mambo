




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidPriceMessage extends MessageDeserializer {
  val messageId = 5755

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidPriceMessage.messageId

    val genericId: Int
    val averagePrice: Int

    def serialize(buf: Buffer) {
      buf.writeInt(genericId)
      buf.writeInt(averagePrice)
    }

  }

  protected def create(genericId: Int, averagePrice: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val genericId = buf.readInt()
    val averagePrice = buf.readInt()

    create(genericId, averagePrice)
  }

}

object ExchangeBidPriceMessage extends ExchangeBidPriceMessage {
  case class MessageImpl(genericId: Int, averagePrice: Int) extends Message
  type Target = MessageImpl

  override def create(genericId: Int, averagePrice: Int) = MessageImpl(genericId, averagePrice)

  def apply(genericId: Int, averagePrice: Int) = create(genericId, averagePrice)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


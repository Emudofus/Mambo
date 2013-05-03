




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHousePriceMessage extends MessageDeserializer {
  val messageId = 5805

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHousePriceMessage.messageId

    val genId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(genId)
    }

  }

  protected def create(genId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val genId = buf.readInt()

    create(genId)
  }

}

object ExchangeBidHousePriceMessage extends ExchangeBidHousePriceMessage {
  case class MessageImpl(genId: Int) extends Message
  type Target = MessageImpl

  override def create(genId: Int) = MessageImpl(genId)

  def apply(genId: Int) = create(genId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


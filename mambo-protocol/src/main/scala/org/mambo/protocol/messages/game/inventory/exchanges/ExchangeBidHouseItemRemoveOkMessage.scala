




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseItemRemoveOkMessage extends MessageDeserializer {
  val messageId = 5946

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseItemRemoveOkMessage.messageId

    val sellerId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(sellerId)
    }

  }

  protected def create(sellerId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val sellerId = buf.readInt()

    create(sellerId)
  }

}

object ExchangeBidHouseItemRemoveOkMessage extends ExchangeBidHouseItemRemoveOkMessage {
  case class MessageImpl(sellerId: Int) extends Message
  type Target = MessageImpl

  override def create(sellerId: Int) = MessageImpl(sellerId)

  def apply(sellerId: Int) = create(sellerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


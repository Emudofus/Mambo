




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseItemAddOkMessage extends MessageDeserializer {
  val messageId = 5945

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseItemAddOkMessage.messageId

    val itemInfo: ObjectItemToSellInBid.TypeImpl

    def serialize(buf: Buffer) {
      itemInfo.serialize(buf)
    }

  }

  protected def create(itemInfo: ObjectItemToSellInBid.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val itemInfo = ObjectItemToSellInBid.deserialize(buf)

    create(itemInfo)
  }

}

object ExchangeBidHouseItemAddOkMessage extends ExchangeBidHouseItemAddOkMessage {
  case class MessageImpl(itemInfo: ObjectItemToSellInBid.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(itemInfo: ObjectItemToSellInBid.TypeImpl) = MessageImpl(itemInfo)

  def apply(itemInfo: ObjectItemToSellInBid.TypeImpl) = create(itemInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


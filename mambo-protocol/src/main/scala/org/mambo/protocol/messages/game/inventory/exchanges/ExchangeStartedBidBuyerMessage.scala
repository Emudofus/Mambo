




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartedBidBuyerMessage extends MessageDeserializer {
  val messageId = 5904

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartedBidBuyerMessage.messageId

    val buyerDescriptor: SellerBuyerDescriptor.TypeImpl

    def serialize(buf: Buffer) {
      buyerDescriptor.serialize(buf)
    }

  }

  protected def create(buyerDescriptor: SellerBuyerDescriptor.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val buyerDescriptor = SellerBuyerDescriptor.deserialize(buf)

    create(buyerDescriptor)
  }

}

object ExchangeStartedBidBuyerMessage extends ExchangeStartedBidBuyerMessage {
  case class MessageImpl(buyerDescriptor: SellerBuyerDescriptor.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(buyerDescriptor: SellerBuyerDescriptor.TypeImpl) = MessageImpl(buyerDescriptor)

  def apply(buyerDescriptor: SellerBuyerDescriptor.TypeImpl) = create(buyerDescriptor)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


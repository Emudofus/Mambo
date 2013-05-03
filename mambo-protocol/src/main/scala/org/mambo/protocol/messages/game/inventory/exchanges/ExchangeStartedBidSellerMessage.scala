




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartedBidSellerMessage extends MessageDeserializer {
  val messageId = 5905

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartedBidSellerMessage.messageId

    val sellerDescriptor: SellerBuyerDescriptor.TypeImpl
    val objectsInfos: Seq[ObjectItemToSellInBid.TypeImpl]

    def serialize(buf: Buffer) {
      sellerDescriptor.serialize(buf)
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(sellerDescriptor: SellerBuyerDescriptor.TypeImpl, objectsInfos: Seq[ObjectItemToSellInBid.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val sellerDescriptor = SellerBuyerDescriptor.deserialize(buf)
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemToSellInBid.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemToSellInBid.deserialize(buf)
      }
      builder.result()
    }

    create(sellerDescriptor, objectsInfos)
  }

}

object ExchangeStartedBidSellerMessage extends ExchangeStartedBidSellerMessage {
  case class MessageImpl(sellerDescriptor: SellerBuyerDescriptor.TypeImpl, objectsInfos: Seq[ObjectItemToSellInBid.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(sellerDescriptor: SellerBuyerDescriptor.TypeImpl, objectsInfos: Seq[ObjectItemToSellInBid.TypeImpl]) = MessageImpl(sellerDescriptor, objectsInfos)

  def apply(sellerDescriptor: SellerBuyerDescriptor.TypeImpl, objectsInfos: Seq[ObjectItemToSellInBid.TypeImpl]) = create(sellerDescriptor, objectsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


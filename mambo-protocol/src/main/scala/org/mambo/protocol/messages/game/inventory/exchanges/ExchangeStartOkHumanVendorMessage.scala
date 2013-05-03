




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkHumanVendorMessage extends MessageDeserializer {
  val messageId = 5767

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkHumanVendorMessage.messageId

    val sellerId: Int
    val objectsInfos: Seq[ObjectItemToSellInHumanVendorShop.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(sellerId)
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(sellerId: Int, objectsInfos: Seq[ObjectItemToSellInHumanVendorShop.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val sellerId = buf.readInt()
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemToSellInHumanVendorShop.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemToSellInHumanVendorShop.deserialize(buf)
      }
      builder.result()
    }

    create(sellerId, objectsInfos)
  }

}

object ExchangeStartOkHumanVendorMessage extends ExchangeStartOkHumanVendorMessage {
  case class MessageImpl(sellerId: Int, objectsInfos: Seq[ObjectItemToSellInHumanVendorShop.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(sellerId: Int, objectsInfos: Seq[ObjectItemToSellInHumanVendorShop.TypeImpl]) = MessageImpl(sellerId, objectsInfos)

  def apply(sellerId: Int, objectsInfos: Seq[ObjectItemToSellInHumanVendorShop.TypeImpl]) = create(sellerId, objectsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


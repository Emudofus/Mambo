




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkNpcShopMessage extends MessageDeserializer {
  val messageId = 5761

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkNpcShopMessage.messageId

    val npcSellerId: Int
    val tokenId: Int
    val objectsInfos: Seq[ObjectItemToSellInNpcShop.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(npcSellerId)
      buf.writeInt(tokenId)
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(npcSellerId: Int, tokenId: Int, objectsInfos: Seq[ObjectItemToSellInNpcShop.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val npcSellerId = buf.readInt()
    val tokenId = buf.readInt()
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemToSellInNpcShop.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemToSellInNpcShop.deserialize(buf)
      }
      builder.result()
    }

    create(npcSellerId, tokenId, objectsInfos)
  }

}

object ExchangeStartOkNpcShopMessage extends ExchangeStartOkNpcShopMessage {
  case class MessageImpl(npcSellerId: Int, tokenId: Int, objectsInfos: Seq[ObjectItemToSellInNpcShop.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(npcSellerId: Int, tokenId: Int, objectsInfos: Seq[ObjectItemToSellInNpcShop.TypeImpl]) = MessageImpl(npcSellerId, tokenId, objectsInfos)

  def apply(npcSellerId: Int, tokenId: Int, objectsInfos: Seq[ObjectItemToSellInNpcShop.TypeImpl]) = create(npcSellerId, tokenId, objectsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


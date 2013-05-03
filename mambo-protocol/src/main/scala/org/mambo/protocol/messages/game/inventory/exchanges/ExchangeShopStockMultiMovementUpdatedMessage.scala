




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeShopStockMultiMovementUpdatedMessage extends MessageDeserializer {
  val messageId = 6038

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeShopStockMultiMovementUpdatedMessage.messageId

    val objectInfoList: Seq[ObjectItemToSell.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectInfoList.length)
      for (entry <- objectInfoList) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(objectInfoList: Seq[ObjectItemToSell.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectInfoList = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemToSell.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemToSell.deserialize(buf)
      }
      builder.result()
    }

    create(objectInfoList)
  }

}

object ExchangeShopStockMultiMovementUpdatedMessage extends ExchangeShopStockMultiMovementUpdatedMessage {
  case class MessageImpl(objectInfoList: Seq[ObjectItemToSell.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(objectInfoList: Seq[ObjectItemToSell.TypeImpl]) = MessageImpl(objectInfoList)

  def apply(objectInfoList: Seq[ObjectItemToSell.TypeImpl]) = create(objectInfoList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


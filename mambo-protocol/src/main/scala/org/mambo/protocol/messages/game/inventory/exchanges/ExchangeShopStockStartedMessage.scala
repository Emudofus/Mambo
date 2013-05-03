




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeShopStockStartedMessage extends MessageDeserializer {
  val messageId = 5910

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeShopStockStartedMessage.messageId

    val objectsInfos: Seq[ObjectItemToSell.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(objectsInfos: Seq[ObjectItemToSell.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemToSell.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemToSell.deserialize(buf)
      }
      builder.result()
    }

    create(objectsInfos)
  }

}

object ExchangeShopStockStartedMessage extends ExchangeShopStockStartedMessage {
  case class MessageImpl(objectsInfos: Seq[ObjectItemToSell.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(objectsInfos: Seq[ObjectItemToSell.TypeImpl]) = MessageImpl(objectsInfos)

  def apply(objectsInfos: Seq[ObjectItemToSell.TypeImpl]) = create(objectsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeTypesItemsExchangerDescriptionForUserMessage extends MessageDeserializer {
  val messageId = 5752

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeTypesItemsExchangerDescriptionForUserMessage.messageId

    val itemTypeDescriptions: Seq[BidExchangerObjectInfo.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(itemTypeDescriptions.length)
      for (entry <- itemTypeDescriptions) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(itemTypeDescriptions: Seq[BidExchangerObjectInfo.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val itemTypeDescriptions = {
      val builder = collection.immutable.Seq.newBuilder[BidExchangerObjectInfo.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += BidExchangerObjectInfo.deserialize(buf)
      }
      builder.result()
    }

    create(itemTypeDescriptions)
  }

}

object ExchangeTypesItemsExchangerDescriptionForUserMessage extends ExchangeTypesItemsExchangerDescriptionForUserMessage {
  case class MessageImpl(itemTypeDescriptions: Seq[BidExchangerObjectInfo.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(itemTypeDescriptions: Seq[BidExchangerObjectInfo.TypeImpl]) = MessageImpl(itemTypeDescriptions)

  def apply(itemTypeDescriptions: Seq[BidExchangerObjectInfo.TypeImpl]) = create(itemTypeDescriptions)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


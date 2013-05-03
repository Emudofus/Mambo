




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartedMountStockMessage extends MessageDeserializer {
  val messageId = 5984

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartedMountStockMessage.messageId

    val objectsInfos: Seq[ObjectItem.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(objectsInfos: Seq[ObjectItem.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }

    create(objectsInfos)
  }

}

object ExchangeStartedMountStockMessage extends ExchangeStartedMountStockMessage {
  case class MessageImpl(objectsInfos: Seq[ObjectItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(objectsInfos: Seq[ObjectItem.TypeImpl]) = MessageImpl(objectsInfos)

  def apply(objectsInfos: Seq[ObjectItem.TypeImpl]) = create(objectsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


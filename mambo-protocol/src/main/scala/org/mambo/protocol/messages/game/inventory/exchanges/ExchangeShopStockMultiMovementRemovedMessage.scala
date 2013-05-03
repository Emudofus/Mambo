




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeShopStockMultiMovementRemovedMessage extends MessageDeserializer {
  val messageId = 6037

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeShopStockMultiMovementRemovedMessage.messageId

    val objectIdList: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectIdList.length)
      for (entry <- objectIdList) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(objectIdList: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectIdList = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(objectIdList)
  }

}

object ExchangeShopStockMultiMovementRemovedMessage extends ExchangeShopStockMultiMovementRemovedMessage {
  case class MessageImpl(objectIdList: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(objectIdList: Seq[Int]) = MessageImpl(objectIdList)

  def apply(objectIdList: Seq[Int]) = create(objectIdList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


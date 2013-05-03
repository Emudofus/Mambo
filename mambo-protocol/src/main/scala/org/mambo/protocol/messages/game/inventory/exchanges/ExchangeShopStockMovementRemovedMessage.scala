




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeShopStockMovementRemovedMessage extends MessageDeserializer {
  val messageId = 5907

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeShopStockMovementRemovedMessage.messageId

    val objectId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objectId)
    }

  }

  protected def create(objectId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectId = buf.readInt()

    create(objectId)
  }

}

object ExchangeShopStockMovementRemovedMessage extends ExchangeShopStockMovementRemovedMessage {
  case class MessageImpl(objectId: Int) extends Message
  type Target = MessageImpl

  override def create(objectId: Int) = MessageImpl(objectId)

  def apply(objectId: Int) = create(objectId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


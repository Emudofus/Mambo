




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeShopStockMovementUpdatedMessage extends MessageDeserializer {
  val messageId = 5909

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeShopStockMovementUpdatedMessage.messageId

    val objectInfo: ObjectItemToSell.TypeImpl

    def serialize(buf: Buffer) {
      objectInfo.serialize(buf)
    }

  }

  protected def create(objectInfo: ObjectItemToSell.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectInfo = ObjectItemToSell.deserialize(buf)

    create(objectInfo)
  }

}

object ExchangeShopStockMovementUpdatedMessage extends ExchangeShopStockMovementUpdatedMessage {
  case class MessageImpl(objectInfo: ObjectItemToSell.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(objectInfo: ObjectItemToSell.TypeImpl) = MessageImpl(objectInfo)

  def apply(objectInfo: ObjectItemToSell.TypeImpl) = create(objectInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


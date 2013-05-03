




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseInListRemovedMessage extends MessageDeserializer {
  val messageId = 5950

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseInListRemovedMessage.messageId

    val itemUID: Int

    def serialize(buf: Buffer) {
      buf.writeInt(itemUID)
    }

  }

  protected def create(itemUID: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val itemUID = buf.readInt()

    create(itemUID)
  }

}

object ExchangeBidHouseInListRemovedMessage extends ExchangeBidHouseInListRemovedMessage {
  case class MessageImpl(itemUID: Int) extends Message
  type Target = MessageImpl

  override def create(itemUID: Int) = MessageImpl(itemUID)

  def apply(itemUID: Int) = create(itemUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseGenericItemRemovedMessage extends MessageDeserializer {
  val messageId = 5948

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseGenericItemRemovedMessage.messageId

    val objGenericId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objGenericId)
    }

  }

  protected def create(objGenericId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objGenericId = buf.readInt()

    create(objGenericId)
  }

}

object ExchangeBidHouseGenericItemRemovedMessage extends ExchangeBidHouseGenericItemRemovedMessage {
  case class MessageImpl(objGenericId: Int) extends Message
  type Target = MessageImpl

  override def create(objGenericId: Int) = MessageImpl(objGenericId)

  def apply(objGenericId: Int) = create(objGenericId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


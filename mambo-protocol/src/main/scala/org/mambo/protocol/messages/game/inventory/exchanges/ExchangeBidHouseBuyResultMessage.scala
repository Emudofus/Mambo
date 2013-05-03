




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseBuyResultMessage extends MessageDeserializer {
  val messageId = 6272

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseBuyResultMessage.messageId

    val uid: Int
    val bought: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(uid)
      buf.writeBoolean(bought)
    }

  }

  protected def create(uid: Int, bought: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val bought = buf.readBoolean()

    create(uid, bought)
  }

}

object ExchangeBidHouseBuyResultMessage extends ExchangeBidHouseBuyResultMessage {
  case class MessageImpl(uid: Int, bought: Boolean) extends Message
  type Target = MessageImpl

  override def create(uid: Int, bought: Boolean) = MessageImpl(uid, bought)

  def apply(uid: Int, bought: Boolean) = create(uid, bought)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


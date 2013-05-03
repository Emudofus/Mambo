




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NumericWhoIsMessage extends MessageDeserializer {
  val messageId = 6297

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NumericWhoIsMessage.messageId

    val playerId: Int
    val accountId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(playerId)
      buf.writeInt(accountId)
    }

  }

  protected def create(playerId: Int, accountId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerId = buf.readInt()
    val accountId = buf.readInt()

    create(playerId, accountId)
  }

}

object NumericWhoIsMessage extends NumericWhoIsMessage {
  case class MessageImpl(playerId: Int, accountId: Int) extends Message
  type Target = MessageImpl

  override def create(playerId: Int, accountId: Int) = MessageImpl(playerId, accountId)

  def apply(playerId: Int, accountId: Int) = create(playerId, accountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


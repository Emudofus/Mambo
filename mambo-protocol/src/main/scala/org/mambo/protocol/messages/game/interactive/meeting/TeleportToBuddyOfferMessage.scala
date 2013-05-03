




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportToBuddyOfferMessage extends MessageDeserializer {
  val messageId = 6287

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportToBuddyOfferMessage.messageId

    val dungeonId: Short
    val buddyId: Int
    val timeLeft: Int

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeInt(buddyId)
      buf.writeInt(timeLeft)
    }

  }

  protected def create(dungeonId: Short, buddyId: Int, timeLeft: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val buddyId = buf.readInt()
    val timeLeft = buf.readInt()

    create(dungeonId, buddyId, timeLeft)
  }

}

object TeleportToBuddyOfferMessage extends TeleportToBuddyOfferMessage {
  case class MessageImpl(dungeonId: Short, buddyId: Int, timeLeft: Int) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, buddyId: Int, timeLeft: Int) = MessageImpl(dungeonId, buddyId, timeLeft)

  def apply(dungeonId: Short, buddyId: Int, timeLeft: Int) = create(dungeonId, buddyId, timeLeft)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


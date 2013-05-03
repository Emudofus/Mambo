




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportToBuddyAnswerMessage extends MessageDeserializer {
  val messageId = 6293

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportToBuddyAnswerMessage.messageId

    val dungeonId: Short
    val buddyId: Int
    val accept: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeInt(buddyId)
      buf.writeBoolean(accept)
    }

  }

  protected def create(dungeonId: Short, buddyId: Int, accept: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val buddyId = buf.readInt()
    val accept = buf.readBoolean()

    create(dungeonId, buddyId, accept)
  }

}

object TeleportToBuddyAnswerMessage extends TeleportToBuddyAnswerMessage {
  case class MessageImpl(dungeonId: Short, buddyId: Int, accept: Boolean) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, buddyId: Int, accept: Boolean) = MessageImpl(dungeonId, buddyId, accept)

  def apply(dungeonId: Short, buddyId: Int, accept: Boolean) = create(dungeonId, buddyId, accept)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


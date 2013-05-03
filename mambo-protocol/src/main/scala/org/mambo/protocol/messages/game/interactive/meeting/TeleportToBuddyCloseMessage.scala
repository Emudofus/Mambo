




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportToBuddyCloseMessage extends MessageDeserializer {
  val messageId = 6303

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportToBuddyCloseMessage.messageId

    val dungeonId: Short
    val buddyId: Int

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeInt(buddyId)
    }

  }

  protected def create(dungeonId: Short, buddyId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val buddyId = buf.readInt()

    create(dungeonId, buddyId)
  }

}

object TeleportToBuddyCloseMessage extends TeleportToBuddyCloseMessage {
  case class MessageImpl(dungeonId: Short, buddyId: Int) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, buddyId: Int) = MessageImpl(dungeonId, buddyId)

  def apply(dungeonId: Short, buddyId: Int) = create(dungeonId, buddyId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportBuddiesRequestedMessage extends MessageDeserializer {
  val messageId = 6302

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportBuddiesRequestedMessage.messageId

    val dungeonId: Short
    val inviterId: Int
    val invalidBuddiesIds: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeInt(inviterId)
      buf.writeUShort(invalidBuddiesIds.length)
      for (entry <- invalidBuddiesIds) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(dungeonId: Short, inviterId: Int, invalidBuddiesIds: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val inviterId = buf.readInt()
    val invalidBuddiesIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(dungeonId, inviterId, invalidBuddiesIds)
  }

}

object TeleportBuddiesRequestedMessage extends TeleportBuddiesRequestedMessage {
  case class MessageImpl(dungeonId: Short, inviterId: Int, invalidBuddiesIds: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, inviterId: Int, invalidBuddiesIds: Seq[Int]) = MessageImpl(dungeonId, inviterId, invalidBuddiesIds)

  def apply(dungeonId: Short, inviterId: Int, invalidBuddiesIds: Seq[Int]) = create(dungeonId, inviterId, invalidBuddiesIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendsListMessage extends MessageDeserializer {
  val messageId = 4002

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FriendsListMessage.messageId

    val friendsList: Seq[FriendInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(friendsList.length)
      for (entry <- friendsList) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(friendsList: Seq[FriendInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val friendsList = {
      val builder = collection.immutable.Seq.newBuilder[FriendInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[FriendInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(friendsList)
  }

}

object FriendsListMessage extends FriendsListMessage {
  case class MessageImpl(friendsList: Seq[FriendInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(friendsList: Seq[FriendInformations.TypeImpl]) = MessageImpl(friendsList)

  def apply(friendsList: Seq[FriendInformations.TypeImpl]) = create(friendsList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


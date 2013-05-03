




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendAddedMessage extends MessageDeserializer {
  val messageId = 5599

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FriendAddedMessage.messageId

    val friendAdded: FriendInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(friendAdded.typeId)
      friendAdded.serialize(buf)
    }

  }

  protected def create(friendAdded: FriendInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val friendAdded = types.get[FriendInformations.TypeImpl](buf.readShort());

    create(friendAdded)
  }

}

object FriendAddedMessage extends FriendAddedMessage {
  case class MessageImpl(friendAdded: FriendInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(friendAdded: FriendInformations.TypeImpl) = MessageImpl(friendAdded)

  def apply(friendAdded: FriendInformations.TypeImpl) = create(friendAdded)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


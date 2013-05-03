




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendUpdateMessage extends MessageDeserializer {
  val messageId = 5924

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FriendUpdateMessage.messageId

    val friendUpdated: FriendInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(friendUpdated.typeId)
      friendUpdated.serialize(buf)
    }

  }

  protected def create(friendUpdated: FriendInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val friendUpdated = types.get[FriendInformations.TypeImpl](buf.readShort());

    create(friendUpdated)
  }

}

object FriendUpdateMessage extends FriendUpdateMessage {
  case class MessageImpl(friendUpdated: FriendInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(friendUpdated: FriendInformations.TypeImpl) = MessageImpl(friendUpdated)

  def apply(friendUpdated: FriendInformations.TypeImpl) = create(friendUpdated)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


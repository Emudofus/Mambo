




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendsListWithSpouseMessage extends FriendsListMessage {
  override val messageId = 5931

  protected trait Message extends FriendsListMessage.Message with Serializable {
    override val messageId = FriendsListWithSpouseMessage.messageId

    val spouse: FriendSpouseInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(spouse.typeId)
      spouse.serialize(buf)
    }

  }

  protected def create(friendsList: Seq[FriendInformations.TypeImpl], spouse: FriendSpouseInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val friendsList = {
      val builder = collection.immutable.Seq.newBuilder[FriendInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[FriendInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val spouse = types.get[FriendSpouseInformations.TypeImpl](buf.readShort());

    create(friendsList, spouse)
  }

}

object FriendsListWithSpouseMessage extends FriendsListWithSpouseMessage {
  case class MessageImpl(friendsList: Seq[FriendInformations.TypeImpl], spouse: FriendSpouseInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(friendsList: Seq[FriendInformations.TypeImpl], spouse: FriendSpouseInformations.TypeImpl) = MessageImpl(friendsList, spouse)

  def apply(friendsList: Seq[FriendInformations.TypeImpl], spouse: FriendSpouseInformations.TypeImpl) = create(friendsList, spouse)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


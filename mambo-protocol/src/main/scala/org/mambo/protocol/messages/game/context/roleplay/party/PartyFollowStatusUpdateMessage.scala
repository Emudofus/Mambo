




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyFollowStatusUpdateMessage extends AbstractPartyMessage {
  override val messageId = 5581

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyFollowStatusUpdateMessage.messageId

    val success: Boolean
    val followedId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(success)
      buf.writeInt(followedId)
    }

  }

  protected def create(partyId: Int, success: Boolean, followedId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val success = buf.readBoolean()
    val followedId = buf.readInt()

    create(partyId, success, followedId)
  }

}

object PartyFollowStatusUpdateMessage extends PartyFollowStatusUpdateMessage {
  case class MessageImpl(partyId: Int, success: Boolean, followedId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, success: Boolean, followedId: Int) = MessageImpl(partyId, success, followedId)

  def apply(partyId: Int, success: Boolean, followedId: Int) = create(partyId, success, followedId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


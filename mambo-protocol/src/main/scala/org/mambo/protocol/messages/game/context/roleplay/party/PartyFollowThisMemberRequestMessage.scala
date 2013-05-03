




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyFollowThisMemberRequestMessage extends PartyFollowMemberRequestMessage {
  override val messageId = 5588

  protected trait Message extends PartyFollowMemberRequestMessage.Message with Serializable {
    override val messageId = PartyFollowThisMemberRequestMessage.messageId

    val enabled: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(enabled)
    }

  }

  protected def create(partyId: Int, playerId: Int, enabled: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val playerId = buf.readInt()
    val enabled = buf.readBoolean()

    create(partyId, playerId, enabled)
  }

}

object PartyFollowThisMemberRequestMessage extends PartyFollowThisMemberRequestMessage {
  case class MessageImpl(partyId: Int, playerId: Int, enabled: Boolean) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, playerId: Int, enabled: Boolean) = MessageImpl(partyId, playerId, enabled)

  def apply(partyId: Int, playerId: Int, enabled: Boolean) = create(partyId, playerId, enabled)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


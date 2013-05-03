




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyMemberRemoveMessage extends AbstractPartyEventMessage {
  override val messageId = 5579

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyMemberRemoveMessage.messageId

    val leavingPlayerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(leavingPlayerId)
    }

  }

  protected def create(partyId: Int, leavingPlayerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val leavingPlayerId = buf.readInt()

    create(partyId, leavingPlayerId)
  }

}

object PartyMemberRemoveMessage extends PartyMemberRemoveMessage {
  case class MessageImpl(partyId: Int, leavingPlayerId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, leavingPlayerId: Int) = MessageImpl(partyId, leavingPlayerId)

  def apply(partyId: Int, leavingPlayerId: Int) = create(partyId, leavingPlayerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


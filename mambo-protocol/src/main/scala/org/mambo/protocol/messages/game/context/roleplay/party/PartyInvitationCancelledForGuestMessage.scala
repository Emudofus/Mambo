




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationCancelledForGuestMessage extends AbstractPartyMessage {
  override val messageId = 6256

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyInvitationCancelledForGuestMessage.messageId

    val cancelerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(cancelerId)
    }

  }

  protected def create(partyId: Int, cancelerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val cancelerId = buf.readInt()

    create(partyId, cancelerId)
  }

}

object PartyInvitationCancelledForGuestMessage extends PartyInvitationCancelledForGuestMessage {
  case class MessageImpl(partyId: Int, cancelerId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, cancelerId: Int) = MessageImpl(partyId, cancelerId)

  def apply(partyId: Int, cancelerId: Int) = create(partyId, cancelerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


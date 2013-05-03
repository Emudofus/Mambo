




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyRefuseInvitationNotificationMessage extends AbstractPartyEventMessage {
  override val messageId = 5596

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyRefuseInvitationNotificationMessage.messageId

    val guestId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(guestId)
    }

  }

  protected def create(partyId: Int, guestId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val guestId = buf.readInt()

    create(partyId, guestId)
  }

}

object PartyRefuseInvitationNotificationMessage extends PartyRefuseInvitationNotificationMessage {
  case class MessageImpl(partyId: Int, guestId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, guestId: Int) = MessageImpl(partyId, guestId)

  def apply(partyId: Int, guestId: Int) = create(partyId, guestId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


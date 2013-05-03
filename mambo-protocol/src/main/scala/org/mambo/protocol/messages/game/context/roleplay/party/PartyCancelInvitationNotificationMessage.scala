




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyCancelInvitationNotificationMessage extends AbstractPartyEventMessage {
  override val messageId = 6251

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyCancelInvitationNotificationMessage.messageId

    val cancelerId: Int
    val guestId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(cancelerId)
      buf.writeInt(guestId)
    }

  }

  protected def create(partyId: Int, cancelerId: Int, guestId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val cancelerId = buf.readInt()
    val guestId = buf.readInt()

    create(partyId, cancelerId, guestId)
  }

}

object PartyCancelInvitationNotificationMessage extends PartyCancelInvitationNotificationMessage {
  case class MessageImpl(partyId: Int, cancelerId: Int, guestId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, cancelerId: Int, guestId: Int) = MessageImpl(partyId, cancelerId, guestId)

  def apply(partyId: Int, cancelerId: Int, guestId: Int) = create(partyId, cancelerId, guestId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


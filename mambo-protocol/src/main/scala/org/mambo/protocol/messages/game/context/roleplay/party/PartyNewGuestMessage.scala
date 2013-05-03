




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyNewGuestMessage extends AbstractPartyEventMessage {
  override val messageId = 6260

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyNewGuestMessage.messageId

    val guest: PartyGuestInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guest.serialize(buf)
    }

  }

  protected def create(partyId: Int, guest: PartyGuestInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val guest = PartyGuestInformations.deserialize(buf)

    create(partyId, guest)
  }

}

object PartyNewGuestMessage extends PartyNewGuestMessage {
  case class MessageImpl(partyId: Int, guest: PartyGuestInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, guest: PartyGuestInformations.TypeImpl) = MessageImpl(partyId, guest)

  def apply(partyId: Int, guest: PartyGuestInformations.TypeImpl) = create(partyId, guest)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


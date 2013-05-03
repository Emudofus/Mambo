




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyUpdateMessage extends AbstractPartyEventMessage {
  override val messageId = 5575

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyUpdateMessage.messageId

    val memberInformations: PartyMemberInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(memberInformations.typeId)
      memberInformations.serialize(buf)
    }

  }

  protected def create(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val memberInformations = types.get[PartyMemberInformations.TypeImpl](buf.readShort());

    create(partyId, memberInformations)
  }

}

object PartyUpdateMessage extends PartyUpdateMessage {
  case class MessageImpl(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl) = MessageImpl(partyId, memberInformations)

  def apply(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl) = create(partyId, memberInformations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


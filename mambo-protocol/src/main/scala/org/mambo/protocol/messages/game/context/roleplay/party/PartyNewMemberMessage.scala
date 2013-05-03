




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyNewMemberMessage extends PartyUpdateMessage {
  override val messageId = 6306

  protected trait Message extends PartyUpdateMessage.Message with Serializable {
    override val messageId = PartyNewMemberMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val memberInformations = types.get[PartyMemberInformations.TypeImpl](buf.readShort());

    create(partyId, memberInformations)
  }

}

object PartyNewMemberMessage extends PartyNewMemberMessage {
  case class MessageImpl(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl) = MessageImpl(partyId, memberInformations)

  def apply(partyId: Int, memberInformations: PartyMemberInformations.TypeImpl) = create(partyId, memberInformations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


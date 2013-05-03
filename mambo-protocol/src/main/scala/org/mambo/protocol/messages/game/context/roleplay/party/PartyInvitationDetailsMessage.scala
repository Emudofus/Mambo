




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationDetailsMessage extends AbstractPartyMessage {
  override val messageId = 6263

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyInvitationDetailsMessage.messageId

    val partyType: Byte
    val fromId: Int
    val fromName: String
    val leaderId: Int
    val members: Seq[PartyInvitationMemberInformations.TypeImpl]
    val guests: Seq[PartyGuestInformations.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(partyType)
      buf.writeInt(fromId)
      buf.writeString(fromName)
      buf.writeInt(leaderId)
      buf.writeUShort(members.length)
      for (entry <- members) {
        entry.serialize(buf)
      }
      buf.writeUShort(guests.length)
      for (entry <- guests) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val partyType = buf.readByte()
    val fromId = buf.readInt()
    val fromName = buf.readString()
    val leaderId = buf.readInt()
    val members = {
      val builder = collection.immutable.Seq.newBuilder[PartyInvitationMemberInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PartyInvitationMemberInformations.deserialize(buf)
      }
      builder.result()
    }
    val guests = {
      val builder = collection.immutable.Seq.newBuilder[PartyGuestInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PartyGuestInformations.deserialize(buf)
      }
      builder.result()
    }

    create(partyId, partyType, fromId, fromName, leaderId, members, guests)
  }

}

object PartyInvitationDetailsMessage extends PartyInvitationDetailsMessage {
  case class MessageImpl(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl]) = MessageImpl(partyId, partyType, fromId, fromName, leaderId, members, guests)

  def apply(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl]) = create(partyId, partyType, fromId, fromName, leaderId, members, guests)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


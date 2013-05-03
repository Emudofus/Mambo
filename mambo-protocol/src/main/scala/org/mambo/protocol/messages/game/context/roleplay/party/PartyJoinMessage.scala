




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyJoinMessage extends AbstractPartyMessage {
  override val messageId = 5576

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyJoinMessage.messageId

    val partyType: Byte
    val partyLeaderId: Int
    val maxParticipants: Byte
    val members: Seq[PartyMemberInformations.TypeImpl]
    val guests: Seq[PartyGuestInformations.TypeImpl]
    val restricted: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(partyType)
      buf.writeInt(partyLeaderId)
      buf.writeByte(maxParticipants)
      buf.writeUShort(members.length)
      for (entry <- members) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(guests.length)
      for (entry <- guests) {
        entry.serialize(buf)
      }
      buf.writeBoolean(restricted)
    }

  }

  protected def create(partyId: Int, partyType: Byte, partyLeaderId: Int, maxParticipants: Byte, members: Seq[PartyMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], restricted: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val partyType = buf.readByte()
    val partyLeaderId = buf.readInt()
    val maxParticipants = buf.readByte()
    val members = {
      val builder = collection.immutable.Seq.newBuilder[PartyMemberInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[PartyMemberInformations.TypeImpl](buf.readShort());
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
    val restricted = buf.readBoolean()

    create(partyId, partyType, partyLeaderId, maxParticipants, members, guests, restricted)
  }

}

object PartyJoinMessage extends PartyJoinMessage {
  case class MessageImpl(partyId: Int, partyType: Byte, partyLeaderId: Int, maxParticipants: Byte, members: Seq[PartyMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], restricted: Boolean) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, partyType: Byte, partyLeaderId: Int, maxParticipants: Byte, members: Seq[PartyMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], restricted: Boolean) = MessageImpl(partyId, partyType, partyLeaderId, maxParticipants, members, guests, restricted)

  def apply(partyId: Int, partyType: Byte, partyLeaderId: Int, maxParticipants: Byte, members: Seq[PartyMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], restricted: Boolean) = create(partyId, partyType, partyLeaderId, maxParticipants, members, guests, restricted)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


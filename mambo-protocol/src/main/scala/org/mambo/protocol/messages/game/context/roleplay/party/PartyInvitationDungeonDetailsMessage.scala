




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage {
  override val messageId = 6262

  protected trait Message extends PartyInvitationDetailsMessage.Message with Serializable {
    override val messageId = PartyInvitationDungeonDetailsMessage.messageId

    val dungeonId: Short
    val playersDungeonReady: Seq[Boolean]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(dungeonId)
      buf.writeUShort(playersDungeonReady.length)
      for (entry <- playersDungeonReady) {
        buf.writeBoolean(entry)
      }
    }

  }

  protected def create(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], dungeonId: Short, playersDungeonReady: Seq[Boolean]): Target = throw new IllegalAccessException

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
    val dungeonId = buf.readShort()
    val playersDungeonReady = {
      val builder = collection.immutable.Seq.newBuilder[Boolean]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readBoolean()
      }
      builder.result()
    }

    create(partyId, partyType, fromId, fromName, leaderId, members, guests, dungeonId, playersDungeonReady)
  }

}

object PartyInvitationDungeonDetailsMessage extends PartyInvitationDungeonDetailsMessage {
  case class MessageImpl(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], dungeonId: Short, playersDungeonReady: Seq[Boolean]) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], dungeonId: Short, playersDungeonReady: Seq[Boolean]) = MessageImpl(partyId, partyType, fromId, fromName, leaderId, members, guests, dungeonId, playersDungeonReady)

  def apply(partyId: Int, partyType: Byte, fromId: Int, fromName: String, leaderId: Int, members: Seq[PartyInvitationMemberInformations.TypeImpl], guests: Seq[PartyGuestInformations.TypeImpl], dungeonId: Short, playersDungeonReady: Seq[Boolean]) = create(partyId, partyType, fromId, fromName, leaderId, members, guests, dungeonId, playersDungeonReady)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


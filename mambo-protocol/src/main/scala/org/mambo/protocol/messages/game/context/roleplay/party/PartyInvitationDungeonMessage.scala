




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationDungeonMessage extends PartyInvitationMessage {
  override val messageId = 6244

  protected trait Message extends PartyInvitationMessage.Message with Serializable {
    override val messageId = PartyInvitationDungeonMessage.messageId

    val dungeonId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(dungeonId)
    }

  }

  protected def create(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int, dungeonId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val partyType = buf.readByte()
    val maxParticipants = buf.readByte()
    val fromId = buf.readInt()
    val fromName = buf.readString()
    val toId = buf.readInt()
    val dungeonId = buf.readShort()

    create(partyId, partyType, maxParticipants, fromId, fromName, toId, dungeonId)
  }

}

object PartyInvitationDungeonMessage extends PartyInvitationDungeonMessage {
  case class MessageImpl(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int, dungeonId: Short) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int, dungeonId: Short) = MessageImpl(partyId, partyType, maxParticipants, fromId, fromName, toId, dungeonId)

  def apply(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int, dungeonId: Short) = create(partyId, partyType, maxParticipants, fromId, fromName, toId, dungeonId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


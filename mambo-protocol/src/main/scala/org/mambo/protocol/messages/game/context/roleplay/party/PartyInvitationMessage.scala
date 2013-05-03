




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationMessage extends AbstractPartyMessage {
  override val messageId = 5586

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyInvitationMessage.messageId

    val partyType: Byte
    val maxParticipants: Byte
    val fromId: Int
    val fromName: String
    val toId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(partyType)
      buf.writeByte(maxParticipants)
      buf.writeInt(fromId)
      buf.writeString(fromName)
      buf.writeInt(toId)
    }

  }

  protected def create(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val partyType = buf.readByte()
    val maxParticipants = buf.readByte()
    val fromId = buf.readInt()
    val fromName = buf.readString()
    val toId = buf.readInt()

    create(partyId, partyType, maxParticipants, fromId, fromName, toId)
  }

}

object PartyInvitationMessage extends PartyInvitationMessage {
  case class MessageImpl(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int) = MessageImpl(partyId, partyType, maxParticipants, fromId, fromName, toId)

  def apply(partyId: Int, partyType: Byte, maxParticipants: Byte, fromId: Int, fromName: String, toId: Int) = create(partyId, partyType, maxParticipants, fromId, fromName, toId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


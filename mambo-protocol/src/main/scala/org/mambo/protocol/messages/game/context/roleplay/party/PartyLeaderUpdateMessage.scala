




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyLeaderUpdateMessage extends AbstractPartyEventMessage {
  override val messageId = 5578

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyLeaderUpdateMessage.messageId

    val partyLeaderId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(partyLeaderId)
    }

  }

  protected def create(partyId: Int, partyLeaderId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val partyLeaderId = buf.readInt()

    create(partyId, partyLeaderId)
  }

}

object PartyLeaderUpdateMessage extends PartyLeaderUpdateMessage {
  case class MessageImpl(partyId: Int, partyLeaderId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, partyLeaderId: Int) = MessageImpl(partyId, partyLeaderId)

  def apply(partyId: Int, partyLeaderId: Int) = create(partyId, partyLeaderId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


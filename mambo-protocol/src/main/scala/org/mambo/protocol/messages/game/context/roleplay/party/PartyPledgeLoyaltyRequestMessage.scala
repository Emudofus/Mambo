




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyPledgeLoyaltyRequestMessage extends AbstractPartyMessage {
  override val messageId = 6269

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyPledgeLoyaltyRequestMessage.messageId

    val loyal: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(loyal)
    }

  }

  protected def create(partyId: Int, loyal: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val loyal = buf.readBoolean()

    create(partyId, loyal)
  }

}

object PartyPledgeLoyaltyRequestMessage extends PartyPledgeLoyaltyRequestMessage {
  case class MessageImpl(partyId: Int, loyal: Boolean) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, loyal: Boolean) = MessageImpl(partyId, loyal)

  def apply(partyId: Int, loyal: Boolean) = create(partyId, loyal)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


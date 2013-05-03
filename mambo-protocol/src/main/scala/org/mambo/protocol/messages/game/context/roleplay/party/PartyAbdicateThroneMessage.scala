




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyAbdicateThroneMessage extends AbstractPartyMessage {
  override val messageId = 6080

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyAbdicateThroneMessage.messageId

    val playerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(playerId)
    }

  }

  protected def create(partyId: Int, playerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val playerId = buf.readInt()

    create(partyId, playerId)
  }

}

object PartyAbdicateThroneMessage extends PartyAbdicateThroneMessage {
  case class MessageImpl(partyId: Int, playerId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, playerId: Int) = MessageImpl(partyId, playerId)

  def apply(partyId: Int, playerId: Int) = create(partyId, playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


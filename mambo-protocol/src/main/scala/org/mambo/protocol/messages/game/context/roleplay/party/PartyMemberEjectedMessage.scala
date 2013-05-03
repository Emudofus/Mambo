




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyMemberEjectedMessage extends PartyMemberRemoveMessage {
  override val messageId = 6252

  protected trait Message extends PartyMemberRemoveMessage.Message with Serializable {
    override val messageId = PartyMemberEjectedMessage.messageId

    val kickerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(kickerId)
    }

  }

  protected def create(partyId: Int, leavingPlayerId: Int, kickerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val leavingPlayerId = buf.readInt()
    val kickerId = buf.readInt()

    create(partyId, leavingPlayerId, kickerId)
  }

}

object PartyMemberEjectedMessage extends PartyMemberEjectedMessage {
  case class MessageImpl(partyId: Int, leavingPlayerId: Int, kickerId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, leavingPlayerId: Int, kickerId: Int) = MessageImpl(partyId, leavingPlayerId, kickerId)

  def apply(partyId: Int, leavingPlayerId: Int, kickerId: Int) = create(partyId, leavingPlayerId, kickerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


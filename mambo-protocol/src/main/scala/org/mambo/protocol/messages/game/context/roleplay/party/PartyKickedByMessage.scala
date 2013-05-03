




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyKickedByMessage extends AbstractPartyMessage {
  override val messageId = 5590

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyKickedByMessage.messageId

    val kickerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(kickerId)
    }

  }

  protected def create(partyId: Int, kickerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val kickerId = buf.readInt()

    create(partyId, kickerId)
  }

}

object PartyKickedByMessage extends PartyKickedByMessage {
  case class MessageImpl(partyId: Int, kickerId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, kickerId: Int) = MessageImpl(partyId, kickerId)

  def apply(partyId: Int, kickerId: Int) = create(partyId, kickerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


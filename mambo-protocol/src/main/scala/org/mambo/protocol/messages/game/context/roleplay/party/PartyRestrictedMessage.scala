




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyRestrictedMessage extends AbstractPartyMessage {
  override val messageId = 6175

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyRestrictedMessage.messageId

    val restricted: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(restricted)
    }

  }

  protected def create(partyId: Int, restricted: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val restricted = buf.readBoolean()

    create(partyId, restricted)
  }

}

object PartyRestrictedMessage extends PartyRestrictedMessage {
  case class MessageImpl(partyId: Int, restricted: Boolean) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, restricted: Boolean) = MessageImpl(partyId, restricted)

  def apply(partyId: Int, restricted: Boolean) = create(partyId, restricted)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


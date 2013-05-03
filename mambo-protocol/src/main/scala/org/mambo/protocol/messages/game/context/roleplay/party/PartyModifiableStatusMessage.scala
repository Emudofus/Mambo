




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyModifiableStatusMessage extends AbstractPartyMessage {
  override val messageId = 6277

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyModifiableStatusMessage.messageId

    val enabled: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(enabled)
    }

  }

  protected def create(partyId: Int, enabled: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val enabled = buf.readBoolean()

    create(partyId, enabled)
  }

}

object PartyModifiableStatusMessage extends PartyModifiableStatusMessage {
  case class MessageImpl(partyId: Int, enabled: Boolean) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, enabled: Boolean) = MessageImpl(partyId, enabled)

  def apply(partyId: Int, enabled: Boolean) = create(partyId, enabled)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


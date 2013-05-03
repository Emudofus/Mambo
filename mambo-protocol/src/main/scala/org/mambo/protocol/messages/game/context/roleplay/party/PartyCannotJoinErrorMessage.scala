




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyCannotJoinErrorMessage extends AbstractPartyMessage {
  override val messageId = 5583

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyCannotJoinErrorMessage.messageId

    val reason: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(reason)
    }

  }

  protected def create(partyId: Int, reason: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val reason = buf.readByte()

    create(partyId, reason)
  }

}

object PartyCannotJoinErrorMessage extends PartyCannotJoinErrorMessage {
  case class MessageImpl(partyId: Int, reason: Byte) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, reason: Byte) = MessageImpl(partyId, reason)

  def apply(partyId: Int, reason: Byte) = create(partyId, reason)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


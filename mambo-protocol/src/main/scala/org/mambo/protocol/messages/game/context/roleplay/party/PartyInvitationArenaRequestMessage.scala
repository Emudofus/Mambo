




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationArenaRequestMessage extends PartyInvitationRequestMessage {
  override val messageId = 6283

  protected trait Message extends PartyInvitationRequestMessage.Message with Serializable {
    override val messageId = PartyInvitationArenaRequestMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val name = buf.readString()

    create(name)
  }

}

object PartyInvitationArenaRequestMessage extends PartyInvitationArenaRequestMessage {
  case class MessageImpl(name: String) extends Message
  type Target = MessageImpl

  override def create(name: String) = MessageImpl(name)

  def apply(name: String) = create(name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


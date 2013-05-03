




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInvitationStateRecrutedMessage extends MessageDeserializer {
  val messageId = 5548

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInvitationStateRecrutedMessage.messageId

    val invitationState: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(invitationState)
    }

  }

  protected def create(invitationState: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val invitationState = buf.readByte()

    create(invitationState)
  }

}

object GuildInvitationStateRecrutedMessage extends GuildInvitationStateRecrutedMessage {
  case class MessageImpl(invitationState: Byte) extends Message
  type Target = MessageImpl

  override def create(invitationState: Byte) = MessageImpl(invitationState)

  def apply(invitationState: Byte) = create(invitationState)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


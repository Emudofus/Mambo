




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInvitationStateRecruterMessage extends MessageDeserializer {
  val messageId = 5563

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInvitationStateRecruterMessage.messageId

    val recrutedName: String
    val invitationState: Byte

    def serialize(buf: Buffer) {
      buf.writeString(recrutedName)
      buf.writeByte(invitationState)
    }

  }

  protected def create(recrutedName: String, invitationState: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val recrutedName = buf.readString()
    val invitationState = buf.readByte()

    create(recrutedName, invitationState)
  }

}

object GuildInvitationStateRecruterMessage extends GuildInvitationStateRecruterMessage {
  case class MessageImpl(recrutedName: String, invitationState: Byte) extends Message
  type Target = MessageImpl

  override def create(recrutedName: String, invitationState: Byte) = MessageImpl(recrutedName, invitationState)

  def apply(recrutedName: String, invitationState: Byte) = create(recrutedName, invitationState)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


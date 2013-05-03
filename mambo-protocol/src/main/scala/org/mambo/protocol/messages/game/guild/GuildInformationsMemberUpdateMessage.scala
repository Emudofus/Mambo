




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInformationsMemberUpdateMessage extends MessageDeserializer {
  val messageId = 5597

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInformationsMemberUpdateMessage.messageId

    val member: GuildMember.TypeImpl

    def serialize(buf: Buffer) {
      member.serialize(buf)
    }

  }

  protected def create(member: GuildMember.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val member = GuildMember.deserialize(buf)

    create(member)
  }

}

object GuildInformationsMemberUpdateMessage extends GuildInformationsMemberUpdateMessage {
  case class MessageImpl(member: GuildMember.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(member: GuildMember.TypeImpl) = MessageImpl(member)

  def apply(member: GuildMember.TypeImpl) = create(member)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


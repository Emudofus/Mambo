




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInvitedMessage extends MessageDeserializer {
  val messageId = 5552

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInvitedMessage.messageId

    val recruterId: Int
    val recruterName: String
    val guildInfo: BasicGuildInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeInt(recruterId)
      buf.writeString(recruterName)
      guildInfo.serialize(buf)
    }

  }

  protected def create(recruterId: Int, recruterName: String, guildInfo: BasicGuildInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val recruterId = buf.readInt()
    val recruterName = buf.readString()
    val guildInfo = BasicGuildInformations.deserialize(buf)

    create(recruterId, recruterName, guildInfo)
  }

}

object GuildInvitedMessage extends GuildInvitedMessage {
  case class MessageImpl(recruterId: Int, recruterName: String, guildInfo: BasicGuildInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(recruterId: Int, recruterName: String, guildInfo: BasicGuildInformations.TypeImpl) = MessageImpl(recruterId, recruterName, guildInfo)

  def apply(recruterId: Int, recruterName: String, guildInfo: BasicGuildInformations.TypeImpl) = create(recruterId, recruterName, guildInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


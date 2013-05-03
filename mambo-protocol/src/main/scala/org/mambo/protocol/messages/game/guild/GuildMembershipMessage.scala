




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildMembershipMessage extends GuildJoinedMessage {
  override val messageId = 5835

  protected trait Message extends GuildJoinedMessage.Message with Serializable {
    override val messageId = GuildMembershipMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val guildInfo = GuildInformations.deserialize(buf)
    val memberRights = buf.readUInt()
    val enabled = buf.readBoolean()

    create(guildInfo, memberRights, enabled)
  }

}

object GuildMembershipMessage extends GuildMembershipMessage {
  case class MessageImpl(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean) extends Message
  type Target = MessageImpl

  override def create(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean) = MessageImpl(guildInfo, memberRights, enabled)

  def apply(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean) = create(guildInfo, memberRights, enabled)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


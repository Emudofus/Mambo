




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildJoinedMessage extends MessageDeserializer {
  val messageId = 5564

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildJoinedMessage.messageId

    val guildInfo: GuildInformations.TypeImpl
    val memberRights: UInt
    val enabled: Boolean

    def serialize(buf: Buffer) {
      guildInfo.serialize(buf)
      buf.writeUInt(memberRights)
      buf.writeBoolean(enabled)
    }

  }

  protected def create(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildInfo = GuildInformations.deserialize(buf)
    val memberRights = buf.readUInt()
    val enabled = buf.readBoolean()

    create(guildInfo, memberRights, enabled)
  }

}

object GuildJoinedMessage extends GuildJoinedMessage {
  case class MessageImpl(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean) extends Message
  type Target = MessageImpl

  override def create(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean) = MessageImpl(guildInfo, memberRights, enabled)

  def apply(guildInfo: GuildInformations.TypeImpl, memberRights: UInt, enabled: Boolean) = create(guildInfo, memberRights, enabled)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


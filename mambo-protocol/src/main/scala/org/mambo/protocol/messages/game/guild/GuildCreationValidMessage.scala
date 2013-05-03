




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildCreationValidMessage extends MessageDeserializer {
  val messageId = 5546

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildCreationValidMessage.messageId

    val guildName: String
    val guildEmblem: GuildEmblem.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeString(guildName)
      guildEmblem.serialize(buf)
    }

  }

  protected def create(guildName: String, guildEmblem: GuildEmblem.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildName = buf.readString()
    val guildEmblem = GuildEmblem.deserialize(buf)

    create(guildName, guildEmblem)
  }

}

object GuildCreationValidMessage extends GuildCreationValidMessage {
  case class MessageImpl(guildName: String, guildEmblem: GuildEmblem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(guildName: String, guildEmblem: GuildEmblem.TypeImpl) = MessageImpl(guildName, guildEmblem)

  def apply(guildName: String, guildEmblem: GuildEmblem.TypeImpl) = create(guildName, guildEmblem)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


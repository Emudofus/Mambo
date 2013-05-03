




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildModificationEmblemValidMessage extends MessageDeserializer {
  val messageId = 6328

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildModificationEmblemValidMessage.messageId

    val guildEmblem: GuildEmblem.TypeImpl

    def serialize(buf: Buffer) {
      guildEmblem.serialize(buf)
    }

  }

  protected def create(guildEmblem: GuildEmblem.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildEmblem = GuildEmblem.deserialize(buf)

    create(guildEmblem)
  }

}

object GuildModificationEmblemValidMessage extends GuildModificationEmblemValidMessage {
  case class MessageImpl(guildEmblem: GuildEmblem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(guildEmblem: GuildEmblem.TypeImpl) = MessageImpl(guildEmblem)

  def apply(guildEmblem: GuildEmblem.TypeImpl) = create(guildEmblem)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


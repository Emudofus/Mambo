




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildModificationNameValidMessage extends MessageDeserializer {
  val messageId = 6327

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildModificationNameValidMessage.messageId

    val guildName: String

    def serialize(buf: Buffer) {
      buf.writeString(guildName)
    }

  }

  protected def create(guildName: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildName = buf.readString()

    create(guildName)
  }

}

object GuildModificationNameValidMessage extends GuildModificationNameValidMessage {
  case class MessageImpl(guildName: String) extends Message
  type Target = MessageImpl

  override def create(guildName: String) = MessageImpl(guildName)

  def apply(guildName: String) = create(guildName)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


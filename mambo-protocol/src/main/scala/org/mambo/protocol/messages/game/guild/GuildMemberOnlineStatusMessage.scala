




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildMemberOnlineStatusMessage extends MessageDeserializer {
  val messageId = 6061

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildMemberOnlineStatusMessage.messageId

    val memberId: Int
    val online: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(memberId)
      buf.writeBoolean(online)
    }

  }

  protected def create(memberId: Int, online: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val memberId = buf.readInt()
    val online = buf.readBoolean()

    create(memberId, online)
  }

}

object GuildMemberOnlineStatusMessage extends GuildMemberOnlineStatusMessage {
  case class MessageImpl(memberId: Int, online: Boolean) extends Message
  type Target = MessageImpl

  override def create(memberId: Int, online: Boolean) = MessageImpl(memberId, online)

  def apply(memberId: Int, online: Boolean) = create(memberId, online)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


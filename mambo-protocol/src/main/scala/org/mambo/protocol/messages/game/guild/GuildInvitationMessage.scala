




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInvitationMessage extends MessageDeserializer {
  val messageId = 5551

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInvitationMessage.messageId

    val targetId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(targetId)
    }

  }

  protected def create(targetId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val targetId = buf.readInt()

    create(targetId)
  }

}

object GuildInvitationMessage extends GuildInvitationMessage {
  case class MessageImpl(targetId: Int) extends Message
  type Target = MessageImpl

  override def create(targetId: Int) = MessageImpl(targetId)

  def apply(targetId: Int) = create(targetId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


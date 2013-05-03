




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildMemberLeavingMessage extends MessageDeserializer {
  val messageId = 5923

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildMemberLeavingMessage.messageId

    val kicked: Boolean
    val memberId: Int

    def serialize(buf: Buffer) {
      buf.writeBoolean(kicked)
      buf.writeInt(memberId)
    }

  }

  protected def create(kicked: Boolean, memberId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val kicked = buf.readBoolean()
    val memberId = buf.readInt()

    create(kicked, memberId)
  }

}

object GuildMemberLeavingMessage extends GuildMemberLeavingMessage {
  case class MessageImpl(kicked: Boolean, memberId: Int) extends Message
  type Target = MessageImpl

  override def create(kicked: Boolean, memberId: Int) = MessageImpl(kicked, memberId)

  def apply(kicked: Boolean, memberId: Int) = create(kicked, memberId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


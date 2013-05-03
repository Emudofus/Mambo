




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildKickRequestMessage extends MessageDeserializer {
  val messageId = 5887

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildKickRequestMessage.messageId

    val kickedId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(kickedId)
    }

  }

  protected def create(kickedId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val kickedId = buf.readInt()

    create(kickedId)
  }

}

object GuildKickRequestMessage extends GuildKickRequestMessage {
  case class MessageImpl(kickedId: Int) extends Message
  type Target = MessageImpl

  override def create(kickedId: Int) = MessageImpl(kickedId)

  def apply(kickedId: Int) = create(kickedId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildPaddockTeleportRequestMessage extends MessageDeserializer {
  val messageId = 5957

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildPaddockTeleportRequestMessage.messageId

    val paddockId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(paddockId)
    }

  }

  protected def create(paddockId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paddockId = buf.readInt()

    create(paddockId)
  }

}

object GuildPaddockTeleportRequestMessage extends GuildPaddockTeleportRequestMessage {
  case class MessageImpl(paddockId: Int) extends Message
  type Target = MessageImpl

  override def create(paddockId: Int) = MessageImpl(paddockId)

  def apply(paddockId: Int) = create(paddockId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


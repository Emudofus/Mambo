




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportBuddiesAnswerMessage extends MessageDeserializer {
  val messageId = 6294

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportBuddiesAnswerMessage.messageId

    val accept: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(accept)
    }

  }

  protected def create(accept: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val accept = buf.readBoolean()

    create(accept)
  }

}

object TeleportBuddiesAnswerMessage extends TeleportBuddiesAnswerMessage {
  case class MessageImpl(accept: Boolean) extends Message
  type Target = MessageImpl

  override def create(accept: Boolean) = MessageImpl(accept)

  def apply(accept: Boolean) = create(accept)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


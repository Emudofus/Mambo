




















// Generated on 05/03/2013 10:34:30
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicPingMessage extends MessageDeserializer {
  val messageId = 182

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicPingMessage.messageId

    val quiet: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(quiet)
    }

  }

  protected def create(quiet: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val quiet = buf.readBoolean()

    create(quiet)
  }

}

object BasicPingMessage extends BasicPingMessage {
  case class MessageImpl(quiet: Boolean) extends Message
  type Target = MessageImpl

  override def create(quiet: Boolean) = MessageImpl(quiet)

  def apply(quiet: Boolean) = create(quiet)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


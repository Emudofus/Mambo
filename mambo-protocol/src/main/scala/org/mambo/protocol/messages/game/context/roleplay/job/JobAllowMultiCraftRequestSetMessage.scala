




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobAllowMultiCraftRequestSetMessage extends MessageDeserializer {
  val messageId = 5749

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobAllowMultiCraftRequestSetMessage.messageId

    val enabled: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(enabled)
    }

  }

  protected def create(enabled: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val enabled = buf.readBoolean()

    create(enabled)
  }

}

object JobAllowMultiCraftRequestSetMessage extends JobAllowMultiCraftRequestSetMessage {
  case class MessageImpl(enabled: Boolean) extends Message
  type Target = MessageImpl

  override def create(enabled: Boolean) = MessageImpl(enabled)

  def apply(enabled: Boolean) = create(enabled)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


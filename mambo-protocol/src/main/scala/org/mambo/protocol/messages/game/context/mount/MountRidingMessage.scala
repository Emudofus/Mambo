




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountRidingMessage extends MessageDeserializer {
  val messageId = 5967

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountRidingMessage.messageId

    val isRiding: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(isRiding)
    }

  }

  protected def create(isRiding: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val isRiding = buf.readBoolean()

    create(isRiding)
  }

}

object MountRidingMessage extends MountRidingMessage {
  case class MessageImpl(isRiding: Boolean) extends Message
  type Target = MessageImpl

  override def create(isRiding: Boolean) = MessageImpl(isRiding)

  def apply(isRiding: Boolean) = create(isRiding)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


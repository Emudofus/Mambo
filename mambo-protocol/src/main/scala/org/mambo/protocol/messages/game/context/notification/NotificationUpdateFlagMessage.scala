




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NotificationUpdateFlagMessage extends MessageDeserializer {
  val messageId = 6090

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NotificationUpdateFlagMessage.messageId

    val index: Short

    def serialize(buf: Buffer) {
      buf.writeShort(index)
    }

  }

  protected def create(index: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val index = buf.readShort()

    create(index)
  }

}

object NotificationUpdateFlagMessage extends NotificationUpdateFlagMessage {
  case class MessageImpl(index: Short) extends Message
  type Target = MessageImpl

  override def create(index: Short) = MessageImpl(index)

  def apply(index: Short) = create(index)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


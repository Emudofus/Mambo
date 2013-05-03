




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QueueStatusMessage extends MessageDeserializer {
  val messageId = 6100

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QueueStatusMessage.messageId

    val position: UShort
    val total: UShort

    def serialize(buf: Buffer) {
      buf.writeUShort(position)
      buf.writeUShort(total)
    }

  }

  protected def create(position: UShort, total: UShort): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val position = buf.readUShort()
    val total = buf.readUShort()

    create(position, total)
  }

}

object QueueStatusMessage extends QueueStatusMessage {
  case class MessageImpl(position: UShort, total: UShort) extends Message
  type Target = MessageImpl

  override def create(position: UShort, total: UShort) = MessageImpl(position, total)

  def apply(position: UShort, total: UShort) = create(position, total)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


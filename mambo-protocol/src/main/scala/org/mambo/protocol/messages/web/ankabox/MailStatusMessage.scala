




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MailStatusMessage extends MessageDeserializer {
  val messageId = 6275

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MailStatusMessage.messageId

    val unread: Short
    val total: Short

    def serialize(buf: Buffer) {
      buf.writeShort(unread)
      buf.writeShort(total)
    }

  }

  protected def create(unread: Short, total: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val unread = buf.readShort()
    val total = buf.readShort()

    create(unread, total)
  }

}

object MailStatusMessage extends MailStatusMessage {
  case class MessageImpl(unread: Short, total: Short) extends Message
  type Target = MessageImpl

  override def create(unread: Short, total: Short) = MessageImpl(unread, total)

  def apply(unread: Short, total: Short) = create(unread, total)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


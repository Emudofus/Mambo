




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatClientPrivateMessage extends ChatAbstractClientMessage {
  override val messageId = 851

  protected trait Message extends ChatAbstractClientMessage.Message with Serializable {
    override val messageId = ChatClientPrivateMessage.messageId

    val receiver: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(receiver)
    }

  }

  protected def create(content: String, receiver: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val content = buf.readString()
    val receiver = buf.readString()

    create(content, receiver)
  }

}

object ChatClientPrivateMessage extends ChatClientPrivateMessage {
  case class MessageImpl(content: String, receiver: String) extends Message
  type Target = MessageImpl

  override def create(content: String, receiver: String) = MessageImpl(content, receiver)

  def apply(content: String, receiver: String) = create(content, receiver)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


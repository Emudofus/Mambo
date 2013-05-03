




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatClientMultiMessage extends ChatAbstractClientMessage {
  override val messageId = 861

  protected trait Message extends ChatAbstractClientMessage.Message with Serializable {
    override val messageId = ChatClientMultiMessage.messageId

    val channel: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(channel)
    }

  }

  protected def create(content: String, channel: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val content = buf.readString()
    val channel = buf.readByte()

    create(content, channel)
  }

}

object ChatClientMultiMessage extends ChatClientMultiMessage {
  case class MessageImpl(content: String, channel: Byte) extends Message
  type Target = MessageImpl

  override def create(content: String, channel: Byte) = MessageImpl(content, channel)

  def apply(content: String, channel: Byte) = create(content, channel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


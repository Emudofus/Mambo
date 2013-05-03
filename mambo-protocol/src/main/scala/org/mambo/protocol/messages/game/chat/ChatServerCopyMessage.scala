




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatServerCopyMessage extends ChatAbstractServerMessage {
  override val messageId = 882

  protected trait Message extends ChatAbstractServerMessage.Message with Serializable {
    override val messageId = ChatServerCopyMessage.messageId

    val receiverId: Int
    val receiverName: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(receiverId)
      buf.writeString(receiverName)
    }

  }

  protected def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val channel = buf.readByte()
    val content = buf.readString()
    val timestamp = buf.readInt()
    val fingerprint = buf.readString()
    val receiverId = buf.readInt()
    val receiverName = buf.readString()

    create(channel, content, timestamp, fingerprint, receiverId, receiverName)
  }

}

object ChatServerCopyMessage extends ChatServerCopyMessage {
  case class MessageImpl(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String) = MessageImpl(channel, content, timestamp, fingerprint, receiverId, receiverName)

  def apply(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String) = create(channel, content, timestamp, fingerprint, receiverId, receiverName)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


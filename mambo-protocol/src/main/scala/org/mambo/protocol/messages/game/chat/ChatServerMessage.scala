




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatServerMessage extends ChatAbstractServerMessage {
  override val messageId = 881

  protected trait Message extends ChatAbstractServerMessage.Message with Serializable {
    override val messageId = ChatServerMessage.messageId

    val senderId: Int
    val senderName: String
    val senderAccountId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(senderId)
      buf.writeString(senderName)
      buf.writeInt(senderAccountId)
    }

  }

  protected def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val channel = buf.readByte()
    val content = buf.readString()
    val timestamp = buf.readInt()
    val fingerprint = buf.readString()
    val senderId = buf.readInt()
    val senderName = buf.readString()
    val senderAccountId = buf.readInt()

    create(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId)
  }

}

object ChatServerMessage extends ChatServerMessage {
  case class MessageImpl(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int) = MessageImpl(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId)

  def apply(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int) = create(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


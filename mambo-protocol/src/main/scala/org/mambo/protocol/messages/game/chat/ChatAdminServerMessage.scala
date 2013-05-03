




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatAdminServerMessage extends ChatServerMessage {
  override val messageId = 6135

  protected trait Message extends ChatServerMessage.Message with Serializable {
    override val messageId = ChatAdminServerMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

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

object ChatAdminServerMessage extends ChatAdminServerMessage {
  case class MessageImpl(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int) = MessageImpl(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId)

  def apply(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int) = create(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


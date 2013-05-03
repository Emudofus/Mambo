




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatMessageReportMessage extends MessageDeserializer {
  val messageId = 821

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChatMessageReportMessage.messageId

    val senderName: String
    val content: String
    val timestamp: Int
    val channel: Byte
    val fingerprint: String
    val reason: Byte

    def serialize(buf: Buffer) {
      buf.writeString(senderName)
      buf.writeString(content)
      buf.writeInt(timestamp)
      buf.writeByte(channel)
      buf.writeString(fingerprint)
      buf.writeByte(reason)
    }

  }

  protected def create(senderName: String, content: String, timestamp: Int, channel: Byte, fingerprint: String, reason: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val senderName = buf.readString()
    val content = buf.readString()
    val timestamp = buf.readInt()
    val channel = buf.readByte()
    val fingerprint = buf.readString()
    val reason = buf.readByte()

    create(senderName, content, timestamp, channel, fingerprint, reason)
  }

}

object ChatMessageReportMessage extends ChatMessageReportMessage {
  case class MessageImpl(senderName: String, content: String, timestamp: Int, channel: Byte, fingerprint: String, reason: Byte) extends Message
  type Target = MessageImpl

  override def create(senderName: String, content: String, timestamp: Int, channel: Byte, fingerprint: String, reason: Byte) = MessageImpl(senderName, content, timestamp, channel, fingerprint, reason)

  def apply(senderName: String, content: String, timestamp: Int, channel: Byte, fingerprint: String, reason: Byte) = create(senderName, content, timestamp, channel, fingerprint, reason)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


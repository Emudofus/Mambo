




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatAbstractServerMessage extends MessageDeserializer {
  val messageId = 880

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChatAbstractServerMessage.messageId

    val channel: Byte
    val content: String
    val timestamp: Int
    val fingerprint: String

    def serialize(buf: Buffer) {
      buf.writeByte(channel)
      buf.writeString(content)
      buf.writeInt(timestamp)
      buf.writeString(fingerprint)
    }

  }

  protected def create(channel: Byte, content: String, timestamp: Int, fingerprint: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val channel = buf.readByte()
    val content = buf.readString()
    val timestamp = buf.readInt()
    val fingerprint = buf.readString()

    create(channel, content, timestamp, fingerprint)
  }

}

object ChatAbstractServerMessage extends ChatAbstractServerMessage {
  case class MessageImpl(channel: Byte, content: String, timestamp: Int, fingerprint: String) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, content: String, timestamp: Int, fingerprint: String) = MessageImpl(channel, content, timestamp, fingerprint)

  def apply(channel: Byte, content: String, timestamp: Int, fingerprint: String) = create(channel, content, timestamp, fingerprint)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


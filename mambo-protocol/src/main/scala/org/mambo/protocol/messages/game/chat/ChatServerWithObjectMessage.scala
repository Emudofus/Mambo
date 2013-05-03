




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatServerWithObjectMessage extends ChatServerMessage {
  override val messageId = 883

  protected trait Message extends ChatServerMessage.Message with Serializable {
    override val messageId = ChatServerWithObjectMessage.messageId

    val objects: Seq[ObjectItem.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(objects.length)
      for (entry <- objects) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int, objects: Seq[ObjectItem.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val channel = buf.readByte()
    val content = buf.readString()
    val timestamp = buf.readInt()
    val fingerprint = buf.readString()
    val senderId = buf.readInt()
    val senderName = buf.readString()
    val senderAccountId = buf.readInt()
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }

    create(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId, objects)
  }

}

object ChatServerWithObjectMessage extends ChatServerWithObjectMessage {
  case class MessageImpl(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int, objects: Seq[ObjectItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int, objects: Seq[ObjectItem.TypeImpl]) = MessageImpl(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId, objects)

  def apply(channel: Byte, content: String, timestamp: Int, fingerprint: String, senderId: Int, senderName: String, senderAccountId: Int, objects: Seq[ObjectItem.TypeImpl]) = create(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId, objects)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


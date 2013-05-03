




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatServerCopyWithObjectMessage extends ChatServerCopyMessage {
  override val messageId = 884

  protected trait Message extends ChatServerCopyMessage.Message with Serializable {
    override val messageId = ChatServerCopyWithObjectMessage.messageId

    val objects: Seq[ObjectItem.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(objects.length)
      for (entry <- objects) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String, objects: Seq[ObjectItem.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val channel = buf.readByte()
    val content = buf.readString()
    val timestamp = buf.readInt()
    val fingerprint = buf.readString()
    val receiverId = buf.readInt()
    val receiverName = buf.readString()
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }

    create(channel, content, timestamp, fingerprint, receiverId, receiverName, objects)
  }

}

object ChatServerCopyWithObjectMessage extends ChatServerCopyWithObjectMessage {
  case class MessageImpl(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String, objects: Seq[ObjectItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String, objects: Seq[ObjectItem.TypeImpl]) = MessageImpl(channel, content, timestamp, fingerprint, receiverId, receiverName, objects)

  def apply(channel: Byte, content: String, timestamp: Int, fingerprint: String, receiverId: Int, receiverName: String, objects: Seq[ObjectItem.TypeImpl]) = create(channel, content, timestamp, fingerprint, receiverId, receiverName, objects)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatClientMultiWithObjectMessage extends ChatClientMultiMessage {
  override val messageId = 862

  protected trait Message extends ChatClientMultiMessage.Message with Serializable {
    override val messageId = ChatClientMultiWithObjectMessage.messageId

    val objects: Seq[ObjectItem.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(objects.length)
      for (entry <- objects) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(content: String, channel: Byte, objects: Seq[ObjectItem.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val content = buf.readString()
    val channel = buf.readByte()
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }

    create(content, channel, objects)
  }

}

object ChatClientMultiWithObjectMessage extends ChatClientMultiWithObjectMessage {
  case class MessageImpl(content: String, channel: Byte, objects: Seq[ObjectItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(content: String, channel: Byte, objects: Seq[ObjectItem.TypeImpl]) = MessageImpl(content, channel, objects)

  def apply(content: String, channel: Byte, objects: Seq[ObjectItem.TypeImpl]) = create(content, channel, objects)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


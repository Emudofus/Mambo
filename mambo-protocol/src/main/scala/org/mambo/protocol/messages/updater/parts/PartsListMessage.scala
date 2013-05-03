




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartsListMessage extends MessageDeserializer {
  val messageId = 1502

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PartsListMessage.messageId

    val parts: Seq[ContentPart.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(parts.length)
      for (entry <- parts) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(parts: Seq[ContentPart.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val parts = {
      val builder = collection.immutable.Seq.newBuilder[ContentPart.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ContentPart.deserialize(buf)
      }
      builder.result()
    }

    create(parts)
  }

}

object PartsListMessage extends PartsListMessage {
  case class MessageImpl(parts: Seq[ContentPart.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(parts: Seq[ContentPart.TypeImpl]) = MessageImpl(parts)

  def apply(parts: Seq[ContentPart.TypeImpl]) = create(parts)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


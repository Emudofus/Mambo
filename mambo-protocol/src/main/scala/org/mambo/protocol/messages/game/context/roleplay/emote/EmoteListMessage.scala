




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EmoteListMessage extends MessageDeserializer {
  val messageId = 5689

  protected trait Message extends BaseMessage with Serializable {
    val messageId = EmoteListMessage.messageId

    val emoteIds: Seq[Byte]

    def serialize(buf: Buffer) {
      buf.writeUShort(emoteIds.length)
      for (entry <- emoteIds) {
        buf.writeByte(entry)
      }
    }

  }

  protected def create(emoteIds: Seq[Byte]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val emoteIds = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }

    create(emoteIds)
  }

}

object EmoteListMessage extends EmoteListMessage {
  case class MessageImpl(emoteIds: Seq[Byte]) extends Message
  type Target = MessageImpl

  override def create(emoteIds: Seq[Byte]) = MessageImpl(emoteIds)

  def apply(emoteIds: Seq[Byte]) = create(emoteIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


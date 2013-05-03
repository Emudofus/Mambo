




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EnabledChannelsMessage extends MessageDeserializer {
  val messageId = 892

  protected trait Message extends BaseMessage with Serializable {
    val messageId = EnabledChannelsMessage.messageId

    val channels: Seq[Byte]
    val disallowed: Seq[Byte]

    def serialize(buf: Buffer) {
      buf.writeUShort(channels.length)
      for (entry <- channels) {
        buf.writeByte(entry)
      }
      buf.writeUShort(disallowed.length)
      for (entry <- disallowed) {
        buf.writeByte(entry)
      }
    }

  }

  protected def create(channels: Seq[Byte], disallowed: Seq[Byte]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val channels = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }
    val disallowed = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }

    create(channels, disallowed)
  }

}

object EnabledChannelsMessage extends EnabledChannelsMessage {
  case class MessageImpl(channels: Seq[Byte], disallowed: Seq[Byte]) extends Message
  type Target = MessageImpl

  override def create(channels: Seq[Byte], disallowed: Seq[Byte]) = MessageImpl(channels, disallowed)

  def apply(channels: Seq[Byte], disallowed: Seq[Byte]) = create(channels, disallowed)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


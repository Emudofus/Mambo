




















// Generated on 05/03/2013 10:34:30
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HelloConnectMessage extends MessageDeserializer {
  val messageId = 3

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HelloConnectMessage.messageId

    val salt: String
    val key: Seq[Byte]

    def serialize(buf: Buffer) {
      buf.writeString(salt)
      buf.writeUShort(key.length)
      for (entry <- key) {
        buf.writeByte(entry)
      }
    }

  }

  protected def create(salt: String, key: Seq[Byte]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val salt = buf.readString()
    val key = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }

    create(salt, key)
  }

}

object HelloConnectMessage extends HelloConnectMessage {
  case class MessageImpl(salt: String, key: Seq[Byte]) extends Message
  type Target = MessageImpl

  override def create(salt: String, key: Seq[Byte]) = MessageImpl(salt, key)

  def apply(salt: String, key: Seq[Byte]) = create(salt, key)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


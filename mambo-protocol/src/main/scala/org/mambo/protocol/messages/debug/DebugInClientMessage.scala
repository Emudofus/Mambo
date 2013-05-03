




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DebugInClientMessage extends MessageDeserializer {
  val messageId = 6028

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DebugInClientMessage.messageId

    val level: Byte
    val message: String

    def serialize(buf: Buffer) {
      buf.writeByte(level)
      buf.writeString(message)
    }

  }

  protected def create(level: Byte, message: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val level = buf.readByte()
    val message = buf.readString()

    create(level, message)
  }

}

object DebugInClientMessage extends DebugInClientMessage {
  case class MessageImpl(level: Byte, message: String) extends Message
  type Target = MessageImpl

  override def create(level: Byte, message: String) = MessageImpl(level, message)

  def apply(level: Byte, message: String) = create(level, message)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LockableCodeResultMessage extends MessageDeserializer {
  val messageId = 5672

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LockableCodeResultMessage.messageId

    val result: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(result)
    }

  }

  protected def create(result: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val result = buf.readByte()

    create(result)
  }

}

object LockableCodeResultMessage extends LockableCodeResultMessage {
  case class MessageImpl(result: Byte) extends Message
  type Target = MessageImpl

  override def create(result: Byte) = MessageImpl(result)

  def apply(result: Byte) = create(result)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicDateMessage extends MessageDeserializer {
  val messageId = 177

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicDateMessage.messageId

    val day: Byte
    val month: Byte
    val year: Short

    def serialize(buf: Buffer) {
      buf.writeByte(day)
      buf.writeByte(month)
      buf.writeShort(year)
    }

  }

  protected def create(day: Byte, month: Byte, year: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val day = buf.readByte()
    val month = buf.readByte()
    val year = buf.readShort()

    create(day, month, year)
  }

}

object BasicDateMessage extends BasicDateMessage {
  case class MessageImpl(day: Byte, month: Byte, year: Short) extends Message
  type Target = MessageImpl

  override def create(day: Byte, month: Byte, year: Short) = MessageImpl(day, month, year)

  def apply(day: Byte, month: Byte, year: Short) = create(day, month, year)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicTimeMessage extends MessageDeserializer {
  val messageId = 175

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicTimeMessage.messageId

    val timestamp: Int
    val timezoneOffset: Short

    def serialize(buf: Buffer) {
      buf.writeInt(timestamp)
      buf.writeShort(timezoneOffset)
    }

  }

  protected def create(timestamp: Int, timezoneOffset: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val timestamp = buf.readInt()
    val timezoneOffset = buf.readShort()

    create(timestamp, timezoneOffset)
  }

}

object BasicTimeMessage extends BasicTimeMessage {
  case class MessageImpl(timestamp: Int, timezoneOffset: Short) extends Message
  type Target = MessageImpl

  override def create(timestamp: Int, timezoneOffset: Short) = MessageImpl(timestamp, timezoneOffset)

  def apply(timestamp: Int, timezoneOffset: Short) = create(timestamp, timezoneOffset)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AlmanachCalendarDateMessage extends MessageDeserializer {
  val messageId = 6341

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AlmanachCalendarDateMessage.messageId

    val date: Int

    def serialize(buf: Buffer) {
      buf.writeInt(date)
    }

  }

  protected def create(date: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val date = buf.readInt()

    create(date)
  }

}

object AlmanachCalendarDateMessage extends AlmanachCalendarDateMessage {
  case class MessageImpl(date: Int) extends Message
  type Target = MessageImpl

  override def create(date: Int) = MessageImpl(date)

  def apply(date: Int) = create(date)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


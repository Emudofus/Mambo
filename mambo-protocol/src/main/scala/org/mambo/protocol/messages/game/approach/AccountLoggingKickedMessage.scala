




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AccountLoggingKickedMessage extends MessageDeserializer {
  val messageId = 6029

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AccountLoggingKickedMessage.messageId

    val days: Int
    val hours: Int
    val minutes: Int

    def serialize(buf: Buffer) {
      buf.writeInt(days)
      buf.writeInt(hours)
      buf.writeInt(minutes)
    }

  }

  protected def create(days: Int, hours: Int, minutes: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val days = buf.readInt()
    val hours = buf.readInt()
    val minutes = buf.readInt()

    create(days, hours, minutes)
  }

}

object AccountLoggingKickedMessage extends AccountLoggingKickedMessage {
  case class MessageImpl(days: Int, hours: Int, minutes: Int) extends Message
  type Target = MessageImpl

  override def create(days: Int, hours: Int, minutes: Int) = MessageImpl(days, hours, minutes)

  def apply(days: Int, hours: Int, minutes: Int) = create(days, hours, minutes)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


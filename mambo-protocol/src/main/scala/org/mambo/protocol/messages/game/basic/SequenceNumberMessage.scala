




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SequenceNumberMessage extends MessageDeserializer {
  val messageId = 6317

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SequenceNumberMessage.messageId

    val number: UShort

    def serialize(buf: Buffer) {
      buf.writeUShort(number)
    }

  }

  protected def create(number: UShort): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val number = buf.readUShort()

    create(number)
  }

}

object SequenceNumberMessage extends SequenceNumberMessage {
  case class MessageImpl(number: UShort) extends Message
  type Target = MessageImpl

  override def create(number: UShort) = MessageImpl(number)

  def apply(number: UShort) = create(number)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


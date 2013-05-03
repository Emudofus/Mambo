




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectGroundRemovedMessage extends MessageDeserializer {
  val messageId = 3014

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectGroundRemovedMessage.messageId

    val cell: Short

    def serialize(buf: Buffer) {
      buf.writeShort(cell)
    }

  }

  protected def create(cell: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cell = buf.readShort()

    create(cell)
  }

}

object ObjectGroundRemovedMessage extends ObjectGroundRemovedMessage {
  case class MessageImpl(cell: Short) extends Message
  type Target = MessageImpl

  override def create(cell: Short) = MessageImpl(cell)

  def apply(cell: Short) = create(cell)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


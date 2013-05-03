




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameMapMovementCancelMessage extends MessageDeserializer {
  val messageId = 953

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameMapMovementCancelMessage.messageId

    val cellId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(cellId)
    }

  }

  protected def create(cellId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()

    create(cellId)
  }

}

object GameMapMovementCancelMessage extends GameMapMovementCancelMessage {
  case class MessageImpl(cellId: Short) extends Message
  type Target = MessageImpl

  override def create(cellId: Short) = MessageImpl(cellId)

  def apply(cellId: Short) = create(cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockMoveItemRequestMessage extends MessageDeserializer {
  val messageId = 6052

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockMoveItemRequestMessage.messageId

    val oldCellId: Short
    val newCellId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(oldCellId)
      buf.writeShort(newCellId)
    }

  }

  protected def create(oldCellId: Short, newCellId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val oldCellId = buf.readShort()
    val newCellId = buf.readShort()

    create(oldCellId, newCellId)
  }

}

object PaddockMoveItemRequestMessage extends PaddockMoveItemRequestMessage {
  case class MessageImpl(oldCellId: Short, newCellId: Short) extends Message
  type Target = MessageImpl

  override def create(oldCellId: Short, newCellId: Short) = MessageImpl(oldCellId, newCellId)

  def apply(oldCellId: Short, newCellId: Short) = create(oldCellId, newCellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


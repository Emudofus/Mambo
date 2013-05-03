




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightUnmarkCellsMessage extends AbstractGameActionMessage {
  override val messageId = 5570

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightUnmarkCellsMessage.messageId

    val markId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(markId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, markId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val markId = buf.readShort()

    create(actionId, sourceId, markId)
  }

}

object GameActionFightUnmarkCellsMessage extends GameActionFightUnmarkCellsMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, markId: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, markId: Short) = MessageImpl(actionId, sourceId, markId)

  def apply(actionId: Short, sourceId: Int, markId: Short) = create(actionId, sourceId, markId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


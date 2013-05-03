




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightSlideMessage extends AbstractGameActionMessage {
  override val messageId = 5525

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightSlideMessage.messageId

    val targetId: Int
    val startCellId: Short
    val endCellId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(startCellId)
      buf.writeShort(endCellId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, startCellId: Short, endCellId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val startCellId = buf.readShort()
    val endCellId = buf.readShort()

    create(actionId, sourceId, targetId, startCellId, endCellId)
  }

}

object GameActionFightSlideMessage extends GameActionFightSlideMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, startCellId: Short, endCellId: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, startCellId: Short, endCellId: Short) = MessageImpl(actionId, sourceId, targetId, startCellId, endCellId)

  def apply(actionId: Short, sourceId: Int, targetId: Int, startCellId: Short, endCellId: Short) = create(actionId, sourceId, targetId, startCellId, endCellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


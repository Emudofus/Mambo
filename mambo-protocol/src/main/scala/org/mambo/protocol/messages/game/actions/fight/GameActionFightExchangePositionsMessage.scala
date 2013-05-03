




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightExchangePositionsMessage extends AbstractGameActionMessage {
  override val messageId = 5527

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightExchangePositionsMessage.messageId

    val targetId: Int
    val casterCellId: Short
    val targetCellId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(casterCellId)
      buf.writeShort(targetCellId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, casterCellId: Short, targetCellId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val casterCellId = buf.readShort()
    val targetCellId = buf.readShort()

    create(actionId, sourceId, targetId, casterCellId, targetCellId)
  }

}

object GameActionFightExchangePositionsMessage extends GameActionFightExchangePositionsMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, casterCellId: Short, targetCellId: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, casterCellId: Short, targetCellId: Short) = MessageImpl(actionId, sourceId, targetId, casterCellId, targetCellId)

  def apply(actionId: Short, sourceId: Int, targetId: Int, casterCellId: Short, targetCellId: Short) = create(actionId, sourceId, targetId, casterCellId, targetCellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightMarkCellsMessage extends AbstractGameActionMessage {
  override val messageId = 5540

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightMarkCellsMessage.messageId

    val mark: GameActionMark.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      mark.serialize(buf)
    }

  }

  protected def create(actionId: Short, sourceId: Int, mark: GameActionMark.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val mark = GameActionMark.deserialize(buf)

    create(actionId, sourceId, mark)
  }

}

object GameActionFightMarkCellsMessage extends GameActionFightMarkCellsMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, mark: GameActionMark.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, mark: GameActionMark.TypeImpl) = MessageImpl(actionId, sourceId, mark)

  def apply(actionId: Short, sourceId: Int, mark: GameActionMark.TypeImpl) = create(actionId, sourceId, mark)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


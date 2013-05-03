




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightInvisibleObstacleMessage extends AbstractGameActionMessage {
  override val messageId = 5820

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightInvisibleObstacleMessage.messageId

    val sourceSpellId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(sourceSpellId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, sourceSpellId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val sourceSpellId = buf.readInt()

    create(actionId, sourceId, sourceSpellId)
  }

}

object GameActionFightInvisibleObstacleMessage extends GameActionFightInvisibleObstacleMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, sourceSpellId: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, sourceSpellId: Int) = MessageImpl(actionId, sourceId, sourceSpellId)

  def apply(actionId: Short, sourceId: Int, sourceSpellId: Int) = create(actionId, sourceId, sourceSpellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


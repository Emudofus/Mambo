




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightStateChangeMessage extends AbstractGameActionMessage {
  override val messageId = 5569

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightStateChangeMessage.messageId

    val targetId: Int
    val stateId: Short
    val active: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(stateId)
      buf.writeBoolean(active)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, stateId: Short, active: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val stateId = buf.readShort()
    val active = buf.readBoolean()

    create(actionId, sourceId, targetId, stateId, active)
  }

}

object GameActionFightStateChangeMessage extends GameActionFightStateChangeMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, stateId: Short, active: Boolean) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, stateId: Short, active: Boolean) = MessageImpl(actionId, sourceId, targetId, stateId, active)

  def apply(actionId: Short, sourceId: Int, targetId: Int, stateId: Short, active: Boolean) = create(actionId, sourceId, targetId, stateId, active)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


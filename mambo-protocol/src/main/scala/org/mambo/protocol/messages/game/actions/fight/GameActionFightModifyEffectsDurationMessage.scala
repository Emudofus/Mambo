




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightModifyEffectsDurationMessage extends AbstractGameActionMessage {
  override val messageId = 6304

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightModifyEffectsDurationMessage.messageId

    val targetId: Int
    val delta: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(delta)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, delta: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val delta = buf.readShort()

    create(actionId, sourceId, targetId, delta)
  }

}

object GameActionFightModifyEffectsDurationMessage extends GameActionFightModifyEffectsDurationMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, delta: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, delta: Short) = MessageImpl(actionId, sourceId, targetId, delta)

  def apply(actionId: Short, sourceId: Int, targetId: Int, delta: Short) = create(actionId, sourceId, targetId, delta)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


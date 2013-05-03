




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightChangeLookMessage extends AbstractGameActionMessage {
  override val messageId = 5532

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightChangeLookMessage.messageId

    val targetId: Int
    val entityLook: EntityLook.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      entityLook.serialize(buf)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, entityLook: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val entityLook = EntityLook.deserialize(buf)

    create(actionId, sourceId, targetId, entityLook)
  }

}

object GameActionFightChangeLookMessage extends GameActionFightChangeLookMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, entityLook: EntityLook.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, entityLook: EntityLook.TypeImpl) = MessageImpl(actionId, sourceId, targetId, entityLook)

  def apply(actionId: Short, sourceId: Int, targetId: Int, entityLook: EntityLook.TypeImpl) = create(actionId, sourceId, targetId, entityLook)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


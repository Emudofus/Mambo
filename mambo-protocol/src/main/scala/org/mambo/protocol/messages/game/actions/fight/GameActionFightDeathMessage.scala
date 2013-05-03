




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightDeathMessage extends AbstractGameActionMessage {
  override val messageId = 1099

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightDeathMessage.messageId

    val targetId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()

    create(actionId, sourceId, targetId)
  }

}

object GameActionFightDeathMessage extends GameActionFightDeathMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int) = MessageImpl(actionId, sourceId, targetId)

  def apply(actionId: Short, sourceId: Int, targetId: Int) = create(actionId, sourceId, targetId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


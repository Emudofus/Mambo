




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightReduceDamagesMessage extends AbstractGameActionMessage {
  override val messageId = 5526

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightReduceDamagesMessage.messageId

    val targetId: Int
    val amount: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeInt(amount)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, amount: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val amount = buf.readInt()

    create(actionId, sourceId, targetId, amount)
  }

}

object GameActionFightReduceDamagesMessage extends GameActionFightReduceDamagesMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, amount: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, amount: Int) = MessageImpl(actionId, sourceId, targetId, amount)

  def apply(actionId: Short, sourceId: Int, targetId: Int, amount: Int) = create(actionId, sourceId, targetId, amount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


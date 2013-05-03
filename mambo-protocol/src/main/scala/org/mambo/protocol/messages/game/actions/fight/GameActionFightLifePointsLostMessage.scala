




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightLifePointsLostMessage extends AbstractGameActionMessage {
  override val messageId = 6312

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightLifePointsLostMessage.messageId

    val targetId: Int
    val loss: Short
    val permanentDamages: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(loss)
      buf.writeShort(permanentDamages)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val loss = buf.readShort()
    val permanentDamages = buf.readShort()

    create(actionId, sourceId, targetId, loss, permanentDamages)
  }

}

object GameActionFightLifePointsLostMessage extends GameActionFightLifePointsLostMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short) = MessageImpl(actionId, sourceId, targetId, loss, permanentDamages)

  def apply(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short) = create(actionId, sourceId, targetId, loss, permanentDamages)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


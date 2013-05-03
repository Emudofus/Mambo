




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifePointsLostMessage {
  override val messageId = 6310

  protected trait Message extends GameActionFightLifePointsLostMessage.Message with Serializable {
    override val messageId = GameActionFightLifeAndShieldPointsLostMessage.messageId

    val shieldLoss: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(shieldLoss)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short, shieldLoss: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val loss = buf.readShort()
    val permanentDamages = buf.readShort()
    val shieldLoss = buf.readShort()

    create(actionId, sourceId, targetId, loss, permanentDamages, shieldLoss)
  }

}

object GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifeAndShieldPointsLostMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short, shieldLoss: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short, shieldLoss: Short) = MessageImpl(actionId, sourceId, targetId, loss, permanentDamages, shieldLoss)

  def apply(actionId: Short, sourceId: Int, targetId: Int, loss: Short, permanentDamages: Short, shieldLoss: Short) = create(actionId, sourceId, targetId, loss, permanentDamages, shieldLoss)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightStealKamaMessage extends AbstractGameActionMessage {
  override val messageId = 5535

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightStealKamaMessage.messageId

    val targetId: Int
    val amount: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(amount)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, amount: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val amount = buf.readShort()

    create(actionId, sourceId, targetId, amount)
  }

}

object GameActionFightStealKamaMessage extends GameActionFightStealKamaMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, amount: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, amount: Short) = MessageImpl(actionId, sourceId, targetId, amount)

  def apply(actionId: Short, sourceId: Int, targetId: Int, amount: Short) = create(actionId, sourceId, targetId, amount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


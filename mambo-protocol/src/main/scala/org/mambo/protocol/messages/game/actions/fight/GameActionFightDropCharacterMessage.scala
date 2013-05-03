




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightDropCharacterMessage extends AbstractGameActionMessage {
  override val messageId = 5826

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightDropCharacterMessage.messageId

    val targetId: Int
    val cellId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(cellId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, cellId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val cellId = buf.readShort()

    create(actionId, sourceId, targetId, cellId)
  }

}

object GameActionFightDropCharacterMessage extends GameActionFightDropCharacterMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, cellId: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, cellId: Short) = MessageImpl(actionId, sourceId, targetId, cellId)

  def apply(actionId: Short, sourceId: Int, targetId: Int, cellId: Short) = create(actionId, sourceId, targetId, cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


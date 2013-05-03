




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightInvisibilityMessage extends AbstractGameActionMessage {
  override val messageId = 5821

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightInvisibilityMessage.messageId

    val targetId: Int
    val state: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeByte(state)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, state: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val state = buf.readByte()

    create(actionId, sourceId, targetId, state)
  }

}

object GameActionFightInvisibilityMessage extends GameActionFightInvisibilityMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, state: Byte) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, state: Byte) = MessageImpl(actionId, sourceId, targetId, state)

  def apply(actionId: Short, sourceId: Int, targetId: Int, state: Byte) = create(actionId, sourceId, targetId, state)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


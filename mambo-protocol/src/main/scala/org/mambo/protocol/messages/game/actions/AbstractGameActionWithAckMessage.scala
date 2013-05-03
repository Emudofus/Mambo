




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AbstractGameActionWithAckMessage extends AbstractGameActionMessage {
  override val messageId = 1001

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = AbstractGameActionWithAckMessage.messageId

    val waitAckId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(waitAckId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, waitAckId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val waitAckId = buf.readShort()

    create(actionId, sourceId, waitAckId)
  }

}

object AbstractGameActionWithAckMessage extends AbstractGameActionWithAckMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, waitAckId: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, waitAckId: Short) = MessageImpl(actionId, sourceId, waitAckId)

  def apply(actionId: Short, sourceId: Int, waitAckId: Short) = create(actionId, sourceId, waitAckId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


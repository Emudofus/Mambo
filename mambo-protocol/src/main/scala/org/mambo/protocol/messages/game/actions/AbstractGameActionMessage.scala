




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AbstractGameActionMessage extends MessageDeserializer {
  val messageId = 1000

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AbstractGameActionMessage.messageId

    val actionId: Short
    val sourceId: Int

    def serialize(buf: Buffer) {
      buf.writeShort(actionId)
      buf.writeInt(sourceId)
    }

  }

  protected def create(actionId: Short, sourceId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()

    create(actionId, sourceId)
  }

}

object AbstractGameActionMessage extends AbstractGameActionMessage {
  case class MessageImpl(actionId: Short, sourceId: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int) = MessageImpl(actionId, sourceId)

  def apply(actionId: Short, sourceId: Int) = create(actionId, sourceId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InteractiveUsedMessage extends MessageDeserializer {
  val messageId = 5745

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InteractiveUsedMessage.messageId

    val entityId: Int
    val elemId: Int
    val skillId: Short
    val duration: Short

    def serialize(buf: Buffer) {
      buf.writeInt(entityId)
      buf.writeInt(elemId)
      buf.writeShort(skillId)
      buf.writeShort(duration)
    }

  }

  protected def create(entityId: Int, elemId: Int, skillId: Short, duration: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val entityId = buf.readInt()
    val elemId = buf.readInt()
    val skillId = buf.readShort()
    val duration = buf.readShort()

    create(entityId, elemId, skillId, duration)
  }

}

object InteractiveUsedMessage extends InteractiveUsedMessage {
  case class MessageImpl(entityId: Int, elemId: Int, skillId: Short, duration: Short) extends Message
  type Target = MessageImpl

  override def create(entityId: Int, elemId: Int, skillId: Short, duration: Short) = MessageImpl(entityId, elemId, skillId, duration)

  def apply(entityId: Int, elemId: Int, skillId: Short, duration: Short) = create(entityId, elemId, skillId, duration)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


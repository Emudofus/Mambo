




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InteractiveUseEndedMessage extends MessageDeserializer {
  val messageId = 6112

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InteractiveUseEndedMessage.messageId

    val elemId: Int
    val skillId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(elemId)
      buf.writeShort(skillId)
    }

  }

  protected def create(elemId: Int, skillId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val elemId = buf.readInt()
    val skillId = buf.readShort()

    create(elemId, skillId)
  }

}

object InteractiveUseEndedMessage extends InteractiveUseEndedMessage {
  case class MessageImpl(elemId: Int, skillId: Short) extends Message
  type Target = MessageImpl

  override def create(elemId: Int, skillId: Short) = MessageImpl(elemId, skillId)

  def apply(elemId: Int, skillId: Short) = create(elemId, skillId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


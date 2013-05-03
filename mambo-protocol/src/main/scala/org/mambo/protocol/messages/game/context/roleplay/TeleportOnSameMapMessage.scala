




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportOnSameMapMessage extends MessageDeserializer {
  val messageId = 6048

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportOnSameMapMessage.messageId

    val targetId: Int
    val cellId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(targetId)
      buf.writeShort(cellId)
    }

  }

  protected def create(targetId: Int, cellId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val targetId = buf.readInt()
    val cellId = buf.readShort()

    create(targetId, cellId)
  }

}

object TeleportOnSameMapMessage extends TeleportOnSameMapMessage {
  case class MessageImpl(targetId: Int, cellId: Short) extends Message
  type Target = MessageImpl

  override def create(targetId: Int, cellId: Short) = MessageImpl(targetId, cellId)

  def apply(targetId: Int, cellId: Short) = create(targetId, cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


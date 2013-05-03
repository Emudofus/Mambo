




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShowCellMessage extends MessageDeserializer {
  val messageId = 5612

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ShowCellMessage.messageId

    val sourceId: Int
    val cellId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(sourceId)
      buf.writeShort(cellId)
    }

  }

  protected def create(sourceId: Int, cellId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val sourceId = buf.readInt()
    val cellId = buf.readShort()

    create(sourceId, cellId)
  }

}

object ShowCellMessage extends ShowCellMessage {
  case class MessageImpl(sourceId: Int, cellId: Short) extends Message
  type Target = MessageImpl

  override def create(sourceId: Int, cellId: Short) = MessageImpl(sourceId, cellId)

  def apply(sourceId: Int, cellId: Short) = create(sourceId, cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


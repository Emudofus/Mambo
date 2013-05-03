




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectUseOnCellMessage extends ObjectUseMessage {
  override val messageId = 3013

  protected trait Message extends ObjectUseMessage.Message with Serializable {
    override val messageId = ObjectUseOnCellMessage.messageId

    val cells: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(cells)
    }

  }

  protected def create(objectUID: Int, cells: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val cells = buf.readShort()

    create(objectUID, cells)
  }

}

object ObjectUseOnCellMessage extends ObjectUseOnCellMessage {
  case class MessageImpl(objectUID: Int, cells: Short) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, cells: Short) = MessageImpl(objectUID, cells)

  def apply(objectUID: Int, cells: Short) = create(objectUID, cells)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


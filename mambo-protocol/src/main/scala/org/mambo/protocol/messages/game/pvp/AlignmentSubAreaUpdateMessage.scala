




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AlignmentSubAreaUpdateMessage extends MessageDeserializer {
  val messageId = 6057

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AlignmentSubAreaUpdateMessage.messageId

    val subAreaId: Short
    val side: Byte
    val quiet: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(subAreaId)
      buf.writeByte(side)
      buf.writeBoolean(quiet)
    }

  }

  protected def create(subAreaId: Short, side: Byte, quiet: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val subAreaId = buf.readShort()
    val side = buf.readByte()
    val quiet = buf.readBoolean()

    create(subAreaId, side, quiet)
  }

}

object AlignmentSubAreaUpdateMessage extends AlignmentSubAreaUpdateMessage {
  case class MessageImpl(subAreaId: Short, side: Byte, quiet: Boolean) extends Message
  type Target = MessageImpl

  override def create(subAreaId: Short, side: Byte, quiet: Boolean) = MessageImpl(subAreaId, side, quiet)

  def apply(subAreaId: Short, side: Byte, quiet: Boolean) = create(subAreaId, side, quiet)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


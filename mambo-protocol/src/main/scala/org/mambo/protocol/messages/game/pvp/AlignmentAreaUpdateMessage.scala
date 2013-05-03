




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AlignmentAreaUpdateMessage extends MessageDeserializer {
  val messageId = 6060

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AlignmentAreaUpdateMessage.messageId

    val areaId: Short
    val side: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(areaId)
      buf.writeByte(side)
    }

  }

  protected def create(areaId: Short, side: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val areaId = buf.readShort()
    val side = buf.readByte()

    create(areaId, side)
  }

}

object AlignmentAreaUpdateMessage extends AlignmentAreaUpdateMessage {
  case class MessageImpl(areaId: Short, side: Byte) extends Message
  type Target = MessageImpl

  override def create(areaId: Short, side: Byte) = MessageImpl(areaId, side)

  def apply(areaId: Short, side: Byte) = create(areaId, side)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


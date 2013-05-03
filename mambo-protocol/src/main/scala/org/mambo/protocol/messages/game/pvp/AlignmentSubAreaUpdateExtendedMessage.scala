




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AlignmentSubAreaUpdateExtendedMessage extends AlignmentSubAreaUpdateMessage {
  override val messageId = 6319

  protected trait Message extends AlignmentSubAreaUpdateMessage.Message with Serializable {
    override val messageId = AlignmentSubAreaUpdateExtendedMessage.messageId

    val worldX: Short
    val worldY: Short
    val mapId: Int
    val eventType: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeByte(eventType)
    }

  }

  protected def create(subAreaId: Short, side: Byte, quiet: Boolean, worldX: Short, worldY: Short, mapId: Int, eventType: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val subAreaId = buf.readShort()
    val side = buf.readByte()
    val quiet = buf.readBoolean()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val eventType = buf.readByte()

    create(subAreaId, side, quiet, worldX, worldY, mapId, eventType)
  }

}

object AlignmentSubAreaUpdateExtendedMessage extends AlignmentSubAreaUpdateExtendedMessage {
  case class MessageImpl(subAreaId: Short, side: Byte, quiet: Boolean, worldX: Short, worldY: Short, mapId: Int, eventType: Byte) extends Message
  type Target = MessageImpl

  override def create(subAreaId: Short, side: Byte, quiet: Boolean, worldX: Short, worldY: Short, mapId: Int, eventType: Byte) = MessageImpl(subAreaId, side, quiet, worldX, worldY, mapId, eventType)

  def apply(subAreaId: Short, side: Byte, quiet: Boolean, worldX: Short, worldY: Short, mapId: Int, eventType: Byte) = create(subAreaId, side, quiet, worldX, worldY, mapId, eventType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightAttackedMessage extends MessageDeserializer {
  val messageId = 5894

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightAttackedMessage.messageId

    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short
    val prismSide: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
      buf.writeByte(prismSide)
    }

  }

  protected def create(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, prismSide: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()
    val prismSide = buf.readByte()

    create(worldX, worldY, mapId, subAreaId, prismSide)
  }

}

object PrismFightAttackedMessage extends PrismFightAttackedMessage {
  case class MessageImpl(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, prismSide: Byte) extends Message
  type Target = MessageImpl

  override def create(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, prismSide: Byte) = MessageImpl(worldX, worldY, mapId, subAreaId, prismSide)

  def apply(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, prismSide: Byte) = create(worldX, worldY, mapId, subAreaId, prismSide)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseToSellFilterMessage extends MessageDeserializer {
  val messageId = 6137

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseToSellFilterMessage.messageId

    val areaId: Int
    val atLeastNbRoom: Byte
    val atLeastNbChest: Byte
    val skillRequested: Short
    val maxPrice: Int

    def serialize(buf: Buffer) {
      buf.writeInt(areaId)
      buf.writeByte(atLeastNbRoom)
      buf.writeByte(atLeastNbChest)
      buf.writeShort(skillRequested)
      buf.writeInt(maxPrice)
    }

  }

  protected def create(areaId: Int, atLeastNbRoom: Byte, atLeastNbChest: Byte, skillRequested: Short, maxPrice: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val areaId = buf.readInt()
    val atLeastNbRoom = buf.readByte()
    val atLeastNbChest = buf.readByte()
    val skillRequested = buf.readShort()
    val maxPrice = buf.readInt()

    create(areaId, atLeastNbRoom, atLeastNbChest, skillRequested, maxPrice)
  }

}

object HouseToSellFilterMessage extends HouseToSellFilterMessage {
  case class MessageImpl(areaId: Int, atLeastNbRoom: Byte, atLeastNbChest: Byte, skillRequested: Short, maxPrice: Int) extends Message
  type Target = MessageImpl

  override def create(areaId: Int, atLeastNbRoom: Byte, atLeastNbChest: Byte, skillRequested: Short, maxPrice: Int) = MessageImpl(areaId, atLeastNbRoom, atLeastNbChest, skillRequested, maxPrice)

  def apply(areaId: Int, atLeastNbRoom: Byte, atLeastNbChest: Byte, skillRequested: Short, maxPrice: Int) = create(areaId, atLeastNbRoom, atLeastNbChest, skillRequested, maxPrice)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


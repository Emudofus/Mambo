




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HouseInformationsForSell extends TypeDeserializer {
  val typeId = 221

  protected trait Type extends BaseType with Serializable {
    val typeId = HouseInformationsForSell.typeId

    val modelId: Int
    val ownerName: String
    val ownerConnected: Boolean
    val worldX: Short
    val worldY: Short
    val subAreaId: Short
    val nbRoom: Byte
    val nbChest: Byte
    val skillListIds: Seq[Int]
    val isLocked: Boolean
    val price: Int

    def serialize(buf: Buffer) {
      buf.writeInt(modelId)
      buf.writeString(ownerName)
      buf.writeBoolean(ownerConnected)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeShort(subAreaId)
      buf.writeByte(nbRoom)
      buf.writeByte(nbChest)
      buf.writeUShort(skillListIds.length)
      for (entry <- skillListIds) {
        buf.writeInt(entry)
      }
      buf.writeBoolean(isLocked)
      buf.writeInt(price)
    }

  }

  protected def create(modelId: Int, ownerName: String, ownerConnected: Boolean, worldX: Short, worldY: Short, subAreaId: Short, nbRoom: Byte, nbChest: Byte, skillListIds: Seq[Int], isLocked: Boolean, price: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val modelId = buf.readInt()
    val ownerName = buf.readString()
    val ownerConnected = buf.readBoolean()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val subAreaId = buf.readShort()
    val nbRoom = buf.readByte()
    val nbChest = buf.readByte()
    val skillListIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val isLocked = buf.readBoolean()
    val price = buf.readInt()

    create(modelId, ownerName, ownerConnected, worldX, worldY, subAreaId, nbRoom, nbChest, skillListIds, isLocked, price)
  }

}

object HouseInformationsForSell extends HouseInformationsForSell {
  case class TypeImpl(modelId: Int, ownerName: String, ownerConnected: Boolean, worldX: Short, worldY: Short, subAreaId: Short, nbRoom: Byte, nbChest: Byte, skillListIds: Seq[Int], isLocked: Boolean, price: Int) extends Type
  override def create(modelId: Int, ownerName: String, ownerConnected: Boolean, worldX: Short, worldY: Short, subAreaId: Short, nbRoom: Byte, nbChest: Byte, skillListIds: Seq[Int], isLocked: Boolean, price: Int) = TypeImpl(modelId, ownerName, ownerConnected, worldX, worldY, subAreaId, nbRoom, nbChest, skillListIds, isLocked, price)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(modelId: Int, ownerName: String, ownerConnected: Boolean, worldX: Short, worldY: Short, subAreaId: Short, nbRoom: Byte, nbChest: Byte, skillListIds: Seq[Int], isLocked: Boolean, price: Int) = create(modelId, ownerName, ownerConnected, worldX, worldY, subAreaId, nbRoom, nbChest, skillListIds, isLocked, price)

  type Target = TypeImpl

}


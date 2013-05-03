




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HouseInformationsInside extends TypeDeserializer {
  val typeId = 218

  protected trait Type extends BaseType with Serializable {
    val typeId = HouseInformationsInside.typeId

    val houseId: Int
    val modelId: Short
    val ownerId: Int
    val ownerName: String
    val worldX: Short
    val worldY: Short
    val price: UInt
    val isLocked: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(houseId)
      buf.writeShort(modelId)
      buf.writeInt(ownerId)
      buf.writeString(ownerName)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeUInt(price)
      buf.writeBoolean(isLocked)
    }

  }

  protected def create(houseId: Int, modelId: Short, ownerId: Int, ownerName: String, worldX: Short, worldY: Short, price: UInt, isLocked: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readInt()
    val modelId = buf.readShort()
    val ownerId = buf.readInt()
    val ownerName = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val price = buf.readUInt()
    val isLocked = buf.readBoolean()

    create(houseId, modelId, ownerId, ownerName, worldX, worldY, price, isLocked)
  }

}

object HouseInformationsInside extends HouseInformationsInside {
  case class TypeImpl(houseId: Int, modelId: Short, ownerId: Int, ownerName: String, worldX: Short, worldY: Short, price: UInt, isLocked: Boolean) extends Type
  override def create(houseId: Int, modelId: Short, ownerId: Int, ownerName: String, worldX: Short, worldY: Short, price: UInt, isLocked: Boolean) = TypeImpl(houseId, modelId, ownerId, ownerName, worldX, worldY, price, isLocked)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(houseId: Int, modelId: Short, ownerId: Int, ownerName: String, worldX: Short, worldY: Short, price: UInt, isLocked: Boolean) = create(houseId, modelId, ownerId, ownerName, worldX, worldY, price, isLocked)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AccountHouseInformations extends TypeDeserializer {
  val typeId = 390

  protected trait Type extends BaseType with Serializable {
    val typeId = AccountHouseInformations.typeId

    val houseId: Int
    val modelId: Short
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(houseId)
      buf.writeShort(modelId)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(houseId: Int, modelId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readInt()
    val modelId = buf.readShort()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(houseId, modelId, worldX, worldY, mapId, subAreaId)
  }

}

object AccountHouseInformations extends AccountHouseInformations {
  case class TypeImpl(houseId: Int, modelId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Type
  override def create(houseId: Int, modelId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = TypeImpl(houseId, modelId, worldX, worldY, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(houseId: Int, modelId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(houseId, modelId, worldX, worldY, mapId, subAreaId)

  type Target = TypeImpl

}


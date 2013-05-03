




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait JobCrafterDirectoryEntryPlayerInfo extends TypeDeserializer {
  val typeId = 194

  protected trait Type extends BaseType with Serializable {
    val typeId = JobCrafterDirectoryEntryPlayerInfo.typeId

    val playerId: Int
    val playerName: String
    val alignmentSide: Byte
    val breed: Byte
    val sex: Boolean
    val isInWorkshop: Boolean
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(playerId)
      buf.writeString(playerName)
      buf.writeByte(alignmentSide)
      buf.writeByte(breed)
      buf.writeBoolean(sex)
      buf.writeBoolean(isInWorkshop)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(playerId: Int, playerName: String, alignmentSide: Byte, breed: Byte, sex: Boolean, isInWorkshop: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerId = buf.readInt()
    val playerName = buf.readString()
    val alignmentSide = buf.readByte()
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val isInWorkshop = buf.readBoolean()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(playerId, playerName, alignmentSide, breed, sex, isInWorkshop, worldX, worldY, mapId, subAreaId)
  }

}

object JobCrafterDirectoryEntryPlayerInfo extends JobCrafterDirectoryEntryPlayerInfo {
  case class TypeImpl(playerId: Int, playerName: String, alignmentSide: Byte, breed: Byte, sex: Boolean, isInWorkshop: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Type
  override def create(playerId: Int, playerName: String, alignmentSide: Byte, breed: Byte, sex: Boolean, isInWorkshop: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = TypeImpl(playerId, playerName, alignmentSide, breed, sex, isInWorkshop, worldX, worldY, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(playerId: Int, playerName: String, alignmentSide: Byte, breed: Byte, sex: Boolean, isInWorkshop: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(playerId, playerName, alignmentSide, breed, sex, isInWorkshop, worldX, worldY, mapId, subAreaId)

  type Target = TypeImpl

}


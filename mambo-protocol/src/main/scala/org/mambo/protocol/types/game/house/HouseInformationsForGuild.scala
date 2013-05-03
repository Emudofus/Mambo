




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HouseInformationsForGuild extends TypeDeserializer {
  val typeId = 170

  protected trait Type extends BaseType with Serializable {
    val typeId = HouseInformationsForGuild.typeId

    val houseId: Int
    val modelId: Int
    val ownerName: String
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short
    val skillListIds: Seq[Int]
    val guildshareParams: UInt

    def serialize(buf: Buffer) {
      buf.writeInt(houseId)
      buf.writeInt(modelId)
      buf.writeString(ownerName)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
      buf.writeUShort(skillListIds.length)
      for (entry <- skillListIds) {
        buf.writeInt(entry)
      }
      buf.writeUInt(guildshareParams)
    }

  }

  protected def create(houseId: Int, modelId: Int, ownerName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, skillListIds: Seq[Int], guildshareParams: UInt): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readInt()
    val modelId = buf.readInt()
    val ownerName = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()
    val skillListIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val guildshareParams = buf.readUInt()

    create(houseId, modelId, ownerName, worldX, worldY, mapId, subAreaId, skillListIds, guildshareParams)
  }

}

object HouseInformationsForGuild extends HouseInformationsForGuild {
  case class TypeImpl(houseId: Int, modelId: Int, ownerName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, skillListIds: Seq[Int], guildshareParams: UInt) extends Type
  override def create(houseId: Int, modelId: Int, ownerName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, skillListIds: Seq[Int], guildshareParams: UInt) = TypeImpl(houseId, modelId, ownerName, worldX, worldY, mapId, subAreaId, skillListIds, guildshareParams)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(houseId: Int, modelId: Int, ownerName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, skillListIds: Seq[Int], guildshareParams: UInt) = create(houseId, modelId, ownerName, worldX, worldY, mapId, subAreaId, skillListIds, guildshareParams)

  type Target = TypeImpl

}


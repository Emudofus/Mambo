




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PartyMemberArenaInformations extends PartyMemberInformations {
  override val typeId = 391

  protected trait Type extends PartyMemberInformations.Type with Serializable {
    override val typeId = PartyMemberArenaInformations.typeId

    val rank: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(rank)
    }

  }

  protected def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte, initiative: Short, pvpEnabled: Boolean, alignmentSide: Byte, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, rank: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val entityLook = EntityLook.deserialize(buf)
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val lifePoints = buf.readInt()
    val maxLifePoints = buf.readInt()
    val prospecting = buf.readShort()
    val regenRate = buf.readUByte()
    val initiative = buf.readShort()
    val pvpEnabled = buf.readBoolean()
    val alignmentSide = buf.readByte()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()
    val rank = buf.readShort()

    create(id, level, name, entityLook, breed, sex, lifePoints, maxLifePoints, prospecting, regenRate, initiative, pvpEnabled, alignmentSide, worldX, worldY, mapId, subAreaId, rank)
  }

}

object PartyMemberArenaInformations extends PartyMemberArenaInformations {
  case class TypeImpl(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte, initiative: Short, pvpEnabled: Boolean, alignmentSide: Byte, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, rank: Short) extends Type
  override def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte, initiative: Short, pvpEnabled: Boolean, alignmentSide: Byte, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, rank: Short) = TypeImpl(id, level, name, entityLook, breed, sex, lifePoints, maxLifePoints, prospecting, regenRate, initiative, pvpEnabled, alignmentSide, worldX, worldY, mapId, subAreaId, rank)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte, initiative: Short, pvpEnabled: Boolean, alignmentSide: Byte, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, rank: Short) = create(id, level, name, entityLook, breed, sex, lifePoints, maxLifePoints, prospecting, regenRate, initiative, pvpEnabled, alignmentSide, worldX, worldY, mapId, subAreaId, rank)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PartyInvitationMemberInformations extends CharacterBaseInformations {
  override val typeId = 376

  protected trait Type extends CharacterBaseInformations.Type with Serializable {
    override val typeId = PartyInvitationMemberInformations.typeId

    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val entityLook = EntityLook.deserialize(buf)
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(id, level, name, entityLook, breed, sex, worldX, worldY, mapId, subAreaId)
  }

}

object PartyInvitationMemberInformations extends PartyInvitationMemberInformations {
  case class TypeImpl(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Type
  override def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = TypeImpl(id, level, name, entityLook, breed, sex, worldX, worldY, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(id, level, name, entityLook, breed, sex, worldX, worldY, mapId, subAreaId)

  type Target = TypeImpl

}


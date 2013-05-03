




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterHardcoreInformations extends CharacterBaseInformations {
  override val typeId = 86

  protected trait Type extends CharacterBaseInformations.Type with Serializable {
    override val typeId = CharacterHardcoreInformations.typeId

    val deathState: Byte
    val deathCount: Short
    val deathMaxLevel: UByte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(deathState)
      buf.writeShort(deathCount)
      buf.writeUByte(deathMaxLevel)
    }

  }

  protected def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, deathState: Byte, deathCount: Short, deathMaxLevel: UByte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val entityLook = EntityLook.deserialize(buf)
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val deathState = buf.readByte()
    val deathCount = buf.readShort()
    val deathMaxLevel = buf.readUByte()

    create(id, level, name, entityLook, breed, sex, deathState, deathCount, deathMaxLevel)
  }

}

object CharacterHardcoreInformations extends CharacterHardcoreInformations {
  case class TypeImpl(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, deathState: Byte, deathCount: Short, deathMaxLevel: UByte) extends Type
  override def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, deathState: Byte, deathCount: Short, deathMaxLevel: UByte) = TypeImpl(id, level, name, entityLook, breed, sex, deathState, deathCount, deathMaxLevel)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean, deathState: Byte, deathCount: Short, deathMaxLevel: UByte) = create(id, level, name, entityLook, breed, sex, deathState, deathCount, deathMaxLevel)

  type Target = TypeImpl

}


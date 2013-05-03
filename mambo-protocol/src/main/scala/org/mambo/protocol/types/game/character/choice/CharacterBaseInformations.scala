




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterBaseInformations extends CharacterMinimalPlusLookInformations {
  override val typeId = 45

  protected trait Type extends CharacterMinimalPlusLookInformations.Type with Serializable {
    override val typeId = CharacterBaseInformations.typeId

    val breed: Byte
    val sex: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(breed)
      buf.writeBoolean(sex)
    }

  }

  protected def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val entityLook = EntityLook.deserialize(buf)
    val breed = buf.readByte()
    val sex = buf.readBoolean()

    create(id, level, name, entityLook, breed, sex)
  }

}

object CharacterBaseInformations extends CharacterBaseInformations {
  case class TypeImpl(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean) extends Type
  override def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean) = TypeImpl(id, level, name, entityLook, breed, sex)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean) = create(id, level, name, entityLook, breed, sex)

  type Target = TypeImpl

}


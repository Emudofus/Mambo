




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterMinimalPlusLookInformations extends CharacterMinimalInformations {
  override val typeId = 163

  protected trait Type extends CharacterMinimalInformations.Type with Serializable {
    override val typeId = CharacterMinimalPlusLookInformations.typeId

    val entityLook: EntityLook.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      entityLook.serialize(buf)
    }

  }

  protected def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val entityLook = EntityLook.deserialize(buf)

    create(id, level, name, entityLook)
  }

}

object CharacterMinimalPlusLookInformations extends CharacterMinimalPlusLookInformations {
  case class TypeImpl(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl) extends Type
  override def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl) = TypeImpl(id, level, name, entityLook)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl) = create(id, level, name, entityLook)

  type Target = TypeImpl

}


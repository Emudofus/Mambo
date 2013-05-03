




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterMinimalPlusLookAndGradeInformations extends CharacterMinimalPlusLookInformations {
  override val typeId = 193

  protected trait Type extends CharacterMinimalPlusLookInformations.Type with Serializable {
    override val typeId = CharacterMinimalPlusLookAndGradeInformations.typeId

    val grade: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(grade)
    }

  }

  protected def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, grade: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val entityLook = EntityLook.deserialize(buf)
    val grade = buf.readInt()

    create(id, level, name, entityLook, grade)
  }

}

object CharacterMinimalPlusLookAndGradeInformations extends CharacterMinimalPlusLookAndGradeInformations {
  case class TypeImpl(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, grade: Int) extends Type
  override def create(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, grade: Int) = TypeImpl(id, level, name, entityLook, grade)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, entityLook: EntityLook.TypeImpl, grade: Int) = create(id, level, name, entityLook, grade)

  type Target = TypeImpl

}


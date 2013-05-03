




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MonsterInGroupInformations extends MonsterInGroupLightInformations {
  override val typeId = 144

  protected trait Type extends MonsterInGroupLightInformations.Type with Serializable {
    override val typeId = MonsterInGroupInformations.typeId

    val look: EntityLook.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      look.serialize(buf)
    }

  }

  protected def create(creatureGenericId: Int, grade: Byte, look: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val creatureGenericId = buf.readInt()
    val grade = buf.readByte()
    val look = EntityLook.deserialize(buf)

    create(creatureGenericId, grade, look)
  }

}

object MonsterInGroupInformations extends MonsterInGroupInformations {
  case class TypeImpl(creatureGenericId: Int, grade: Byte, look: EntityLook.TypeImpl) extends Type
  override def create(creatureGenericId: Int, grade: Byte, look: EntityLook.TypeImpl) = TypeImpl(creatureGenericId, grade, look)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(creatureGenericId: Int, grade: Byte, look: EntityLook.TypeImpl) = create(creatureGenericId, grade, look)

  type Target = TypeImpl

}


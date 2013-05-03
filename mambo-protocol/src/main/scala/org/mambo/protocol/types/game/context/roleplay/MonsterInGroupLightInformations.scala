




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MonsterInGroupLightInformations extends TypeDeserializer {
  val typeId = 395

  protected trait Type extends BaseType with Serializable {
    val typeId = MonsterInGroupLightInformations.typeId

    val creatureGenericId: Int
    val grade: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(creatureGenericId)
      buf.writeByte(grade)
    }

  }

  protected def create(creatureGenericId: Int, grade: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val creatureGenericId = buf.readInt()
    val grade = buf.readByte()

    create(creatureGenericId, grade)
  }

}

object MonsterInGroupLightInformations extends MonsterInGroupLightInformations {
  case class TypeImpl(creatureGenericId: Int, grade: Byte) extends Type
  override def create(creatureGenericId: Int, grade: Byte) = TypeImpl(creatureGenericId, grade)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(creatureGenericId: Int, grade: Byte) = create(creatureGenericId, grade)

  type Target = TypeImpl

}


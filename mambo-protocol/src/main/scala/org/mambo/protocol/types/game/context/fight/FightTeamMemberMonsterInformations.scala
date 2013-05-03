




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTeamMemberMonsterInformations extends FightTeamMemberInformations {
  override val typeId = 6

  protected trait Type extends FightTeamMemberInformations.Type with Serializable {
    override val typeId = FightTeamMemberMonsterInformations.typeId

    val monsterId: Int
    val grade: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(monsterId)
      buf.writeByte(grade)
    }

  }

  protected def create(id: Int, monsterId: Int, grade: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val monsterId = buf.readInt()
    val grade = buf.readByte()

    create(id, monsterId, grade)
  }

}

object FightTeamMemberMonsterInformations extends FightTeamMemberMonsterInformations {
  case class TypeImpl(id: Int, monsterId: Int, grade: Byte) extends Type
  override def create(id: Int, monsterId: Int, grade: Byte) = TypeImpl(id, monsterId, grade)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, monsterId: Int, grade: Byte) = create(id, monsterId, grade)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTeamMemberTaxCollectorInformations extends FightTeamMemberInformations {
  override val typeId = 177

  protected trait Type extends FightTeamMemberInformations.Type with Serializable {
    override val typeId = FightTeamMemberTaxCollectorInformations.typeId

    val firstNameId: Short
    val lastNameId: Short
    val level: UByte
    val guildId: Int
    val uid: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(firstNameId)
      buf.writeShort(lastNameId)
      buf.writeUByte(level)
      buf.writeInt(guildId)
      buf.writeInt(uid)
    }

  }

  protected def create(id: Int, firstNameId: Short, lastNameId: Short, level: UByte, guildId: Int, uid: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val firstNameId = buf.readShort()
    val lastNameId = buf.readShort()
    val level = buf.readUByte()
    val guildId = buf.readInt()
    val uid = buf.readInt()

    create(id, firstNameId, lastNameId, level, guildId, uid)
  }

}

object FightTeamMemberTaxCollectorInformations extends FightTeamMemberTaxCollectorInformations {
  case class TypeImpl(id: Int, firstNameId: Short, lastNameId: Short, level: UByte, guildId: Int, uid: Int) extends Type
  override def create(id: Int, firstNameId: Short, lastNameId: Short, level: UByte, guildId: Int, uid: Int) = TypeImpl(id, firstNameId, lastNameId, level, guildId, uid)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, firstNameId: Short, lastNameId: Short, level: UByte, guildId: Int, uid: Int) = create(id, firstNameId, lastNameId, level, guildId, uid)

  type Target = TypeImpl

}


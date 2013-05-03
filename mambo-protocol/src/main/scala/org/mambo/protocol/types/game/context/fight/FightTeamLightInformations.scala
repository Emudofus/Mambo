




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTeamLightInformations extends AbstractFightTeamInformations {
  override val typeId = 115

  protected trait Type extends AbstractFightTeamInformations.Type with Serializable {
    override val typeId = FightTeamLightInformations.typeId

    val teamMembersCount: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(teamMembersCount)
    }

  }

  protected def create(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembersCount: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val teamId = buf.readByte()
    val leaderId = buf.readInt()
    val teamSide = buf.readByte()
    val teamTypeId = buf.readByte()
    val teamMembersCount = buf.readByte()

    create(teamId, leaderId, teamSide, teamTypeId, teamMembersCount)
  }

}

object FightTeamLightInformations extends FightTeamLightInformations {
  case class TypeImpl(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembersCount: Byte) extends Type
  override def create(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembersCount: Byte) = TypeImpl(teamId, leaderId, teamSide, teamTypeId, teamMembersCount)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembersCount: Byte) = create(teamId, leaderId, teamSide, teamTypeId, teamMembersCount)

  type Target = TypeImpl

}


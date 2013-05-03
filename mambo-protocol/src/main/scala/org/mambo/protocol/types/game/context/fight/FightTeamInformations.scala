




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTeamInformations extends AbstractFightTeamInformations {
  override val typeId = 33

  protected trait Type extends AbstractFightTeamInformations.Type with Serializable {
    override val typeId = FightTeamInformations.typeId

    val teamMembers: Seq[FightTeamMemberInformations.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(teamMembers.length)
      for (entry <- teamMembers) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembers: Seq[FightTeamMemberInformations.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val teamId = buf.readByte()
    val leaderId = buf.readInt()
    val teamSide = buf.readByte()
    val teamTypeId = buf.readByte()
    val teamMembers = {
      val builder = collection.immutable.Seq.newBuilder[FightTeamMemberInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[FightTeamMemberInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(teamId, leaderId, teamSide, teamTypeId, teamMembers)
  }

}

object FightTeamInformations extends FightTeamInformations {
  case class TypeImpl(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembers: Seq[FightTeamMemberInformations.TypeImpl]) extends Type
  override def create(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembers: Seq[FightTeamMemberInformations.TypeImpl]) = TypeImpl(teamId, leaderId, teamSide, teamTypeId, teamMembers)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte, teamMembers: Seq[FightTeamMemberInformations.TypeImpl]) = create(teamId, leaderId, teamSide, teamTypeId, teamMembers)

  type Target = TypeImpl

}


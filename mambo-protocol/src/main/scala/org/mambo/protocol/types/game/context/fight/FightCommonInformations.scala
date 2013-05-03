




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightCommonInformations extends TypeDeserializer {
  val typeId = 43

  protected trait Type extends BaseType with Serializable {
    val typeId = FightCommonInformations.typeId

    val fightId: Int
    val fightType: Byte
    val fightTeams: Seq[FightTeamInformations.TypeImpl]
    val fightTeamsPositions: Seq[Short]
    val fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeByte(fightType)
      buf.writeUShort(fightTeams.length)
      for (entry <- fightTeams) {
        entry.serialize(buf)
      }
      buf.writeUShort(fightTeamsPositions.length)
      for (entry <- fightTeamsPositions) {
        buf.writeShort(entry)
      }
      buf.writeUShort(fightTeamsOptions.length)
      for (entry <- fightTeamsOptions) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(fightId: Int, fightType: Byte, fightTeams: Seq[FightTeamInformations.TypeImpl], fightTeamsPositions: Seq[Short], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val fightType = buf.readByte()
    val fightTeams = {
      val builder = collection.immutable.Seq.newBuilder[FightTeamInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += FightTeamInformations.deserialize(buf)
      }
      builder.result()
    }
    val fightTeamsPositions = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val fightTeamsOptions = {
      val builder = collection.immutable.Seq.newBuilder[FightOptionsInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += FightOptionsInformations.deserialize(buf)
      }
      builder.result()
    }

    create(fightId, fightType, fightTeams, fightTeamsPositions, fightTeamsOptions)
  }

}

object FightCommonInformations extends FightCommonInformations {
  case class TypeImpl(fightId: Int, fightType: Byte, fightTeams: Seq[FightTeamInformations.TypeImpl], fightTeamsPositions: Seq[Short], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]) extends Type
  override def create(fightId: Int, fightType: Byte, fightTeams: Seq[FightTeamInformations.TypeImpl], fightTeamsPositions: Seq[Short], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]) = TypeImpl(fightId, fightType, fightTeams, fightTeamsPositions, fightTeamsOptions)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(fightId: Int, fightType: Byte, fightTeams: Seq[FightTeamInformations.TypeImpl], fightTeamsPositions: Seq[Short], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]) = create(fightId, fightType, fightTeams, fightTeamsPositions, fightTeamsOptions)

  type Target = TypeImpl

}


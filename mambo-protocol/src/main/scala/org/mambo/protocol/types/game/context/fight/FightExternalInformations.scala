




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightExternalInformations extends TypeDeserializer {
  val typeId = 117

  protected trait Type extends BaseType with Serializable {
    val typeId = FightExternalInformations.typeId

    val fightId: Int
    val fightStart: Int
    val fightSpectatorLocked: Boolean
    val fightTeams: Seq[FightTeamLightInformations.TypeImpl]
    val fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeInt(fightStart)
      buf.writeBoolean(fightSpectatorLocked)
      buf.writeUShort(fightTeams.length)
      for (entry <- fightTeams) {
        entry.serialize(buf)
      }
      buf.writeUShort(fightTeamsOptions.length)
      for (entry <- fightTeamsOptions) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(fightId: Int, fightStart: Int, fightSpectatorLocked: Boolean, fightTeams: Seq[FightTeamLightInformations.TypeImpl], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val fightStart = buf.readInt()
    val fightSpectatorLocked = buf.readBoolean()
    val fightTeams = {
      val builder = collection.immutable.Seq.newBuilder[FightTeamLightInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += FightTeamLightInformations.deserialize(buf)
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

    create(fightId, fightStart, fightSpectatorLocked, fightTeams, fightTeamsOptions)
  }

}

object FightExternalInformations extends FightExternalInformations {
  case class TypeImpl(fightId: Int, fightStart: Int, fightSpectatorLocked: Boolean, fightTeams: Seq[FightTeamLightInformations.TypeImpl], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]) extends Type
  override def create(fightId: Int, fightStart: Int, fightSpectatorLocked: Boolean, fightTeams: Seq[FightTeamLightInformations.TypeImpl], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]) = TypeImpl(fightId, fightStart, fightSpectatorLocked, fightTeams, fightTeamsOptions)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(fightId: Int, fightStart: Int, fightSpectatorLocked: Boolean, fightTeams: Seq[FightTeamLightInformations.TypeImpl], fightTeamsOptions: Seq[FightOptionsInformations.TypeImpl]) = create(fightId, fightStart, fightSpectatorLocked, fightTeams, fightTeamsOptions)

  type Target = TypeImpl

}


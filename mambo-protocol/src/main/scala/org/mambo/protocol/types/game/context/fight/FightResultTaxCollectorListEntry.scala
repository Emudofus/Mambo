




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultTaxCollectorListEntry extends FightResultFighterListEntry {
  override val typeId = 84

  protected trait Type extends FightResultFighterListEntry.Type with Serializable {
    override val typeId = FightResultTaxCollectorListEntry.typeId

    val level: UByte
    val guildInfo: BasicGuildInformations.TypeImpl
    val experienceForGuild: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(level)
      guildInfo.serialize(buf)
      buf.writeInt(experienceForGuild)
    }

  }

  protected def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, guildInfo: BasicGuildInformations.TypeImpl, experienceForGuild: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val outcome = buf.readShort()
    val rewards = FightLoot.deserialize(buf)
    val id = buf.readInt()
    val alive = buf.readBoolean()
    val level = buf.readUByte()
    val guildInfo = BasicGuildInformations.deserialize(buf)
    val experienceForGuild = buf.readInt()

    create(outcome, rewards, id, alive, level, guildInfo, experienceForGuild)
  }

}

object FightResultTaxCollectorListEntry extends FightResultTaxCollectorListEntry {
  case class TypeImpl(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, guildInfo: BasicGuildInformations.TypeImpl, experienceForGuild: Int) extends Type
  override def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, guildInfo: BasicGuildInformations.TypeImpl, experienceForGuild: Int) = TypeImpl(outcome, rewards, id, alive, level, guildInfo, experienceForGuild)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, guildInfo: BasicGuildInformations.TypeImpl, experienceForGuild: Int) = create(outcome, rewards, id, alive, level, guildInfo, experienceForGuild)

  type Target = TypeImpl

}


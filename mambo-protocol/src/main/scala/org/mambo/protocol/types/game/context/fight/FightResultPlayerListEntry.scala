




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultPlayerListEntry extends FightResultFighterListEntry {
  override val typeId = 24

  protected trait Type extends FightResultFighterListEntry.Type with Serializable {
    override val typeId = FightResultPlayerListEntry.typeId

    val level: UByte
    val additional: Seq[FightResultAdditionalData.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(level)
      buf.writeUShort(additional.length)
      for (entry <- additional) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, additional: Seq[FightResultAdditionalData.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val outcome = buf.readShort()
    val rewards = FightLoot.deserialize(buf)
    val id = buf.readInt()
    val alive = buf.readBoolean()
    val level = buf.readUByte()
    val additional = {
      val builder = collection.immutable.Seq.newBuilder[FightResultAdditionalData.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[FightResultAdditionalData.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(outcome, rewards, id, alive, level, additional)
  }

}

object FightResultPlayerListEntry extends FightResultPlayerListEntry {
  case class TypeImpl(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, additional: Seq[FightResultAdditionalData.TypeImpl]) extends Type
  override def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, additional: Seq[FightResultAdditionalData.TypeImpl]) = TypeImpl(outcome, rewards, id, alive, level, additional)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UByte, additional: Seq[FightResultAdditionalData.TypeImpl]) = create(outcome, rewards, id, alive, level, additional)

  type Target = TypeImpl

}


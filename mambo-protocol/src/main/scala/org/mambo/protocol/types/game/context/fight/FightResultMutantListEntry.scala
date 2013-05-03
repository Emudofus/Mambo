




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultMutantListEntry extends FightResultFighterListEntry {
  override val typeId = 216

  protected trait Type extends FightResultFighterListEntry.Type with Serializable {
    override val typeId = FightResultMutantListEntry.typeId

    val level: UShort

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(level)
    }

  }

  protected def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UShort): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val outcome = buf.readShort()
    val rewards = FightLoot.deserialize(buf)
    val id = buf.readInt()
    val alive = buf.readBoolean()
    val level = buf.readUShort()

    create(outcome, rewards, id, alive, level)
  }

}

object FightResultMutantListEntry extends FightResultMutantListEntry {
  case class TypeImpl(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UShort) extends Type
  override def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UShort) = TypeImpl(outcome, rewards, id, alive, level)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean, level: UShort) = create(outcome, rewards, id, alive, level)

  type Target = TypeImpl

}


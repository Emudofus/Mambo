




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultFighterListEntry extends FightResultListEntry {
  override val typeId = 189

  protected trait Type extends FightResultListEntry.Type with Serializable {
    override val typeId = FightResultFighterListEntry.typeId

    val id: Int
    val alive: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(id)
      buf.writeBoolean(alive)
    }

  }

  protected def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val outcome = buf.readShort()
    val rewards = FightLoot.deserialize(buf)
    val id = buf.readInt()
    val alive = buf.readBoolean()

    create(outcome, rewards, id, alive)
  }

}

object FightResultFighterListEntry extends FightResultFighterListEntry {
  case class TypeImpl(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean) extends Type
  override def create(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean) = TypeImpl(outcome, rewards, id, alive)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(outcome: Short, rewards: FightLoot.TypeImpl, id: Int, alive: Boolean) = create(outcome, rewards, id, alive)

  type Target = TypeImpl

}


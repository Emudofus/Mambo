




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultListEntry extends TypeDeserializer {
  val typeId = 16

  protected trait Type extends BaseType with Serializable {
    val typeId = FightResultListEntry.typeId

    val outcome: Short
    val rewards: FightLoot.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeShort(outcome)
      rewards.serialize(buf)
    }

  }

  protected def create(outcome: Short, rewards: FightLoot.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val outcome = buf.readShort()
    val rewards = FightLoot.deserialize(buf)

    create(outcome, rewards)
  }

}

object FightResultListEntry extends FightResultListEntry {
  case class TypeImpl(outcome: Short, rewards: FightLoot.TypeImpl) extends Type
  override def create(outcome: Short, rewards: FightLoot.TypeImpl) = TypeImpl(outcome, rewards)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(outcome: Short, rewards: FightLoot.TypeImpl) = create(outcome, rewards)

  type Target = TypeImpl

}


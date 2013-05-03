




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectLadder extends ObjectEffectCreature {
  override val typeId = 81

  protected trait Type extends ObjectEffectCreature.Type with Serializable {
    override val typeId = ObjectEffectLadder.typeId

    val monsterCount: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(monsterCount)
    }

  }

  protected def create(actionId: Short, monsterFamilyId: Short, monsterCount: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val monsterFamilyId = buf.readShort()
    val monsterCount = buf.readInt()

    create(actionId, monsterFamilyId, monsterCount)
  }

}

object ObjectEffectLadder extends ObjectEffectLadder {
  case class TypeImpl(actionId: Short, monsterFamilyId: Short, monsterCount: Int) extends Type
  override def create(actionId: Short, monsterFamilyId: Short, monsterCount: Int) = TypeImpl(actionId, monsterFamilyId, monsterCount)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, monsterFamilyId: Short, monsterCount: Int) = create(actionId, monsterFamilyId, monsterCount)

  type Target = TypeImpl

}


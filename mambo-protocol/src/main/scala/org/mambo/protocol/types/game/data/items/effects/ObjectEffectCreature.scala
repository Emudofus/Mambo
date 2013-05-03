




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectCreature extends ObjectEffect {
  override val typeId = 71

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectCreature.typeId

    val monsterFamilyId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(monsterFamilyId)
    }

  }

  protected def create(actionId: Short, monsterFamilyId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val monsterFamilyId = buf.readShort()

    create(actionId, monsterFamilyId)
  }

}

object ObjectEffectCreature extends ObjectEffectCreature {
  case class TypeImpl(actionId: Short, monsterFamilyId: Short) extends Type
  override def create(actionId: Short, monsterFamilyId: Short) = TypeImpl(actionId, monsterFamilyId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, monsterFamilyId: Short) = create(actionId, monsterFamilyId)

  type Target = TypeImpl

}


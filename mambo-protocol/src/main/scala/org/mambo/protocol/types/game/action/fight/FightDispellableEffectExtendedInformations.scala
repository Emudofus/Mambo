




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightDispellableEffectExtendedInformations extends TypeDeserializer {
  val typeId = 208

  protected trait Type extends BaseType with Serializable {
    val typeId = FightDispellableEffectExtendedInformations.typeId

    val actionId: Short
    val sourceId: Int
    val effect: AbstractFightDispellableEffect.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeShort(actionId)
      buf.writeInt(sourceId)
      buf.writeUShort(effect.typeId)
      effect.serialize(buf)
    }

  }

  protected def create(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val effect = types.get[AbstractFightDispellableEffect.TypeImpl](buf.readShort());

    create(actionId, sourceId, effect)
  }

}

object FightDispellableEffectExtendedInformations extends FightDispellableEffectExtendedInformations {
  case class TypeImpl(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl) extends Type
  override def create(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl) = TypeImpl(actionId, sourceId, effect)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl) = create(actionId, sourceId, effect)

  type Target = TypeImpl

}


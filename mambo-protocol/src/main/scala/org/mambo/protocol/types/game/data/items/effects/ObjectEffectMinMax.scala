




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectMinMax extends ObjectEffect {
  override val typeId = 82

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectMinMax.typeId

    val min: Short
    val max: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(min)
      buf.writeShort(max)
    }

  }

  protected def create(actionId: Short, min: Short, max: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val min = buf.readShort()
    val max = buf.readShort()

    create(actionId, min, max)
  }

}

object ObjectEffectMinMax extends ObjectEffectMinMax {
  case class TypeImpl(actionId: Short, min: Short, max: Short) extends Type
  override def create(actionId: Short, min: Short, max: Short) = TypeImpl(actionId, min, max)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, min: Short, max: Short) = create(actionId, min, max)

  type Target = TypeImpl

}


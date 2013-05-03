




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectInteger extends ObjectEffect {
  override val typeId = 70

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectInteger.typeId

    val value: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(value)
    }

  }

  protected def create(actionId: Short, value: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val value = buf.readShort()

    create(actionId, value)
  }

}

object ObjectEffectInteger extends ObjectEffectInteger {
  case class TypeImpl(actionId: Short, value: Short) extends Type
  override def create(actionId: Short, value: Short) = TypeImpl(actionId, value)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, value: Short) = create(actionId, value)

  type Target = TypeImpl

}


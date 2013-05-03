




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectString extends ObjectEffect {
  override val typeId = 74

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectString.typeId

    val value: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(value)
    }

  }

  protected def create(actionId: Short, value: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val value = buf.readString()

    create(actionId, value)
  }

}

object ObjectEffectString extends ObjectEffectString {
  case class TypeImpl(actionId: Short, value: String) extends Type
  override def create(actionId: Short, value: String) = TypeImpl(actionId, value)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, value: String) = create(actionId, value)

  type Target = TypeImpl

}


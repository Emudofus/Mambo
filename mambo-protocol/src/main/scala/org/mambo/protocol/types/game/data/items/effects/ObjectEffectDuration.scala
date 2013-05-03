




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectDuration extends ObjectEffect {
  override val typeId = 75

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectDuration.typeId

    val days: Short
    val hours: Short
    val minutes: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(days)
      buf.writeShort(hours)
      buf.writeShort(minutes)
    }

  }

  protected def create(actionId: Short, days: Short, hours: Short, minutes: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val days = buf.readShort()
    val hours = buf.readShort()
    val minutes = buf.readShort()

    create(actionId, days, hours, minutes)
  }

}

object ObjectEffectDuration extends ObjectEffectDuration {
  case class TypeImpl(actionId: Short, days: Short, hours: Short, minutes: Short) extends Type
  override def create(actionId: Short, days: Short, hours: Short, minutes: Short) = TypeImpl(actionId, days, hours, minutes)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, days: Short, hours: Short, minutes: Short) = create(actionId, days, hours, minutes)

  type Target = TypeImpl

}


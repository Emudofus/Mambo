




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectDate extends ObjectEffect {
  override val typeId = 72

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectDate.typeId

    val year: Short
    val month: Short
    val day: Short
    val hour: Short
    val minute: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(year)
      buf.writeShort(month)
      buf.writeShort(day)
      buf.writeShort(hour)
      buf.writeShort(minute)
    }

  }

  protected def create(actionId: Short, year: Short, month: Short, day: Short, hour: Short, minute: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val year = buf.readShort()
    val month = buf.readShort()
    val day = buf.readShort()
    val hour = buf.readShort()
    val minute = buf.readShort()

    create(actionId, year, month, day, hour, minute)
  }

}

object ObjectEffectDate extends ObjectEffectDate {
  case class TypeImpl(actionId: Short, year: Short, month: Short, day: Short, hour: Short, minute: Short) extends Type
  override def create(actionId: Short, year: Short, month: Short, day: Short, hour: Short, minute: Short) = TypeImpl(actionId, year, month, day, hour, minute)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, year: Short, month: Short, day: Short, hour: Short, minute: Short) = create(actionId, year, month, day, hour, minute)

  type Target = TypeImpl

}


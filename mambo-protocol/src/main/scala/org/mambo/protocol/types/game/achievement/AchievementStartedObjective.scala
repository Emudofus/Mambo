




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AchievementStartedObjective extends AchievementObjective {
  override val typeId = 402

  protected trait Type extends AchievementObjective.Type with Serializable {
    override val typeId = AchievementStartedObjective.typeId

    val value: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(value)
    }

  }

  protected def create(id: Int, maxValue: Short, value: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val maxValue = buf.readShort()
    val value = buf.readShort()

    create(id, maxValue, value)
  }

}

object AchievementStartedObjective extends AchievementStartedObjective {
  case class TypeImpl(id: Int, maxValue: Short, value: Short) extends Type
  override def create(id: Int, maxValue: Short, value: Short) = TypeImpl(id, maxValue, value)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, maxValue: Short, value: Short) = create(id, maxValue, value)

  type Target = TypeImpl

}


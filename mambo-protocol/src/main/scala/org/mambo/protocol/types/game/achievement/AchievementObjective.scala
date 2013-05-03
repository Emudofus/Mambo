




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AchievementObjective extends TypeDeserializer {
  val typeId = 404

  protected trait Type extends BaseType with Serializable {
    val typeId = AchievementObjective.typeId

    val id: Int
    val maxValue: Short

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      buf.writeShort(maxValue)
    }

  }

  protected def create(id: Int, maxValue: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val maxValue = buf.readShort()

    create(id, maxValue)
  }

}

object AchievementObjective extends AchievementObjective {
  case class TypeImpl(id: Int, maxValue: Short) extends Type
  override def create(id: Int, maxValue: Short) = TypeImpl(id, maxValue)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, maxValue: Short) = create(id, maxValue)

  type Target = TypeImpl

}


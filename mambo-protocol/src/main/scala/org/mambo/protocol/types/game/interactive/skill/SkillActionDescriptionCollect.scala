




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SkillActionDescriptionCollect extends SkillActionDescriptionTimed {
  override val typeId = 99

  protected trait Type extends SkillActionDescriptionTimed.Type with Serializable {
    override val typeId = SkillActionDescriptionCollect.typeId

    val min: Short
    val max: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(min)
      buf.writeShort(max)
    }

  }

  protected def create(skillId: Short, time: UByte, min: Short, max: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val skillId = buf.readShort()
    val time = buf.readUByte()
    val min = buf.readShort()
    val max = buf.readShort()

    create(skillId, time, min, max)
  }

}

object SkillActionDescriptionCollect extends SkillActionDescriptionCollect {
  case class TypeImpl(skillId: Short, time: UByte, min: Short, max: Short) extends Type
  override def create(skillId: Short, time: UByte, min: Short, max: Short) = TypeImpl(skillId, time, min, max)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Short, time: UByte, min: Short, max: Short) = create(skillId, time, min, max)

  type Target = TypeImpl

}


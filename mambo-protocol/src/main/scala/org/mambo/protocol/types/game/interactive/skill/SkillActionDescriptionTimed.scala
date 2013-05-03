




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SkillActionDescriptionTimed extends SkillActionDescription {
  override val typeId = 103

  protected trait Type extends SkillActionDescription.Type with Serializable {
    override val typeId = SkillActionDescriptionTimed.typeId

    val time: UByte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(time)
    }

  }

  protected def create(skillId: Short, time: UByte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val skillId = buf.readShort()
    val time = buf.readUByte()

    create(skillId, time)
  }

}

object SkillActionDescriptionTimed extends SkillActionDescriptionTimed {
  case class TypeImpl(skillId: Short, time: UByte) extends Type
  override def create(skillId: Short, time: UByte) = TypeImpl(skillId, time)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Short, time: UByte) = create(skillId, time)

  type Target = TypeImpl

}


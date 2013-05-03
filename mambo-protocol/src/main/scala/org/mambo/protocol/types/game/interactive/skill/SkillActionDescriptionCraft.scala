




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SkillActionDescriptionCraft extends SkillActionDescription {
  override val typeId = 100

  protected trait Type extends SkillActionDescription.Type with Serializable {
    override val typeId = SkillActionDescriptionCraft.typeId

    val maxSlots: Byte
    val probability: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(maxSlots)
      buf.writeByte(probability)
    }

  }

  protected def create(skillId: Short, maxSlots: Byte, probability: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val skillId = buf.readShort()
    val maxSlots = buf.readByte()
    val probability = buf.readByte()

    create(skillId, maxSlots, probability)
  }

}

object SkillActionDescriptionCraft extends SkillActionDescriptionCraft {
  case class TypeImpl(skillId: Short, maxSlots: Byte, probability: Byte) extends Type
  override def create(skillId: Short, maxSlots: Byte, probability: Byte) = TypeImpl(skillId, maxSlots, probability)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Short, maxSlots: Byte, probability: Byte) = create(skillId, maxSlots, probability)

  type Target = TypeImpl

}


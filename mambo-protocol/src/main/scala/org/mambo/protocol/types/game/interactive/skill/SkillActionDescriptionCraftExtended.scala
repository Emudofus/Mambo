




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SkillActionDescriptionCraftExtended extends SkillActionDescriptionCraft {
  override val typeId = 104

  protected trait Type extends SkillActionDescriptionCraft.Type with Serializable {
    override val typeId = SkillActionDescriptionCraftExtended.typeId

    val thresholdSlots: Byte
    val optimumProbability: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(thresholdSlots)
      buf.writeByte(optimumProbability)
    }

  }

  protected def create(skillId: Short, maxSlots: Byte, probability: Byte, thresholdSlots: Byte, optimumProbability: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val skillId = buf.readShort()
    val maxSlots = buf.readByte()
    val probability = buf.readByte()
    val thresholdSlots = buf.readByte()
    val optimumProbability = buf.readByte()

    create(skillId, maxSlots, probability, thresholdSlots, optimumProbability)
  }

}

object SkillActionDescriptionCraftExtended extends SkillActionDescriptionCraftExtended {
  case class TypeImpl(skillId: Short, maxSlots: Byte, probability: Byte, thresholdSlots: Byte, optimumProbability: Byte) extends Type
  override def create(skillId: Short, maxSlots: Byte, probability: Byte, thresholdSlots: Byte, optimumProbability: Byte) = TypeImpl(skillId, maxSlots, probability, thresholdSlots, optimumProbability)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Short, maxSlots: Byte, probability: Byte, thresholdSlots: Byte, optimumProbability: Byte) = create(skillId, maxSlots, probability, thresholdSlots, optimumProbability)

  type Target = TypeImpl

}


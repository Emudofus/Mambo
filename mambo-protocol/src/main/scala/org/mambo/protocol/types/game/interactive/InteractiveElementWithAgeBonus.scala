




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait InteractiveElementWithAgeBonus extends InteractiveElement {
  override val typeId = 398

  protected trait Type extends InteractiveElement.Type with Serializable {
    override val typeId = InteractiveElementWithAgeBonus.typeId

    val ageBonus: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(ageBonus)
    }

  }

  protected def create(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl], ageBonus: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val elementId = buf.readInt()
    val elementTypeId = buf.readInt()
    val enabledSkills = {
      val builder = collection.immutable.Seq.newBuilder[InteractiveElementSkill.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[InteractiveElementSkill.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val disabledSkills = {
      val builder = collection.immutable.Seq.newBuilder[InteractiveElementSkill.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[InteractiveElementSkill.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val ageBonus = buf.readShort()

    create(elementId, elementTypeId, enabledSkills, disabledSkills, ageBonus)
  }

}

object InteractiveElementWithAgeBonus extends InteractiveElementWithAgeBonus {
  case class TypeImpl(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl], ageBonus: Short) extends Type
  override def create(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl], ageBonus: Short) = TypeImpl(elementId, elementTypeId, enabledSkills, disabledSkills, ageBonus)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl], ageBonus: Short) = create(elementId, elementTypeId, enabledSkills, disabledSkills, ageBonus)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait InteractiveElement extends TypeDeserializer {
  val typeId = 80

  protected trait Type extends BaseType with Serializable {
    val typeId = InteractiveElement.typeId

    val elementId: Int
    val elementTypeId: Int
    val enabledSkills: Seq[InteractiveElementSkill.TypeImpl]
    val disabledSkills: Seq[InteractiveElementSkill.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(elementId)
      buf.writeInt(elementTypeId)
      buf.writeUShort(enabledSkills.length)
      for (entry <- enabledSkills) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(disabledSkills.length)
      for (entry <- disabledSkills) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
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

    create(elementId, elementTypeId, enabledSkills, disabledSkills)
  }

}

object InteractiveElement extends InteractiveElement {
  case class TypeImpl(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl]) extends Type
  override def create(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl]) = TypeImpl(elementId, elementTypeId, enabledSkills, disabledSkills)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(elementId: Int, elementTypeId: Int, enabledSkills: Seq[InteractiveElementSkill.TypeImpl], disabledSkills: Seq[InteractiveElementSkill.TypeImpl]) = create(elementId, elementTypeId, enabledSkills, disabledSkills)

  type Target = TypeImpl

}


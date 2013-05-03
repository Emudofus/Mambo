




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SkillActionDescription extends TypeDeserializer {
  val typeId = 102

  protected trait Type extends BaseType with Serializable {
    val typeId = SkillActionDescription.typeId

    val skillId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(skillId)
    }

  }

  protected def create(skillId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val skillId = buf.readShort()

    create(skillId)
  }

}

object SkillActionDescription extends SkillActionDescription {
  case class TypeImpl(skillId: Short) extends Type
  override def create(skillId: Short) = TypeImpl(skillId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Short) = create(skillId)

  type Target = TypeImpl

}


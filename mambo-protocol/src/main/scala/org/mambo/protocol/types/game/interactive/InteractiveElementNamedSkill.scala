




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait InteractiveElementNamedSkill extends InteractiveElementSkill {
  override val typeId = 220

  protected trait Type extends InteractiveElementSkill.Type with Serializable {
    override val typeId = InteractiveElementNamedSkill.typeId

    val nameId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(nameId)
    }

  }

  protected def create(skillId: Int, skillInstanceUid: Int, nameId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val skillId = buf.readInt()
    val skillInstanceUid = buf.readInt()
    val nameId = buf.readInt()

    create(skillId, skillInstanceUid, nameId)
  }

}

object InteractiveElementNamedSkill extends InteractiveElementNamedSkill {
  case class TypeImpl(skillId: Int, skillInstanceUid: Int, nameId: Int) extends Type
  override def create(skillId: Int, skillInstanceUid: Int, nameId: Int) = TypeImpl(skillId, skillInstanceUid, nameId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Int, skillInstanceUid: Int, nameId: Int) = create(skillId, skillInstanceUid, nameId)

  type Target = TypeImpl

}


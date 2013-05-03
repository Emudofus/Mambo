




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait InteractiveElementSkill extends TypeDeserializer {
  val typeId = 219

  protected trait Type extends BaseType with Serializable {
    val typeId = InteractiveElementSkill.typeId

    val skillId: Int
    val skillInstanceUid: Int

    def serialize(buf: Buffer) {
      buf.writeInt(skillId)
      buf.writeInt(skillInstanceUid)
    }

  }

  protected def create(skillId: Int, skillInstanceUid: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val skillId = buf.readInt()
    val skillInstanceUid = buf.readInt()

    create(skillId, skillInstanceUid)
  }

}

object InteractiveElementSkill extends InteractiveElementSkill {
  case class TypeImpl(skillId: Int, skillInstanceUid: Int) extends Type
  override def create(skillId: Int, skillInstanceUid: Int) = TypeImpl(skillId, skillInstanceUid)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(skillId: Int, skillInstanceUid: Int) = create(skillId, skillInstanceUid)

  type Target = TypeImpl

}


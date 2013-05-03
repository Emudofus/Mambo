




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTeamMemberCharacterInformations extends FightTeamMemberInformations {
  override val typeId = 13

  protected trait Type extends FightTeamMemberInformations.Type with Serializable {
    override val typeId = FightTeamMemberCharacterInformations.typeId

    val name: String
    val level: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
      buf.writeShort(level)
    }

  }

  protected def create(id: Int, name: String, level: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val name = buf.readString()
    val level = buf.readShort()

    create(id, name, level)
  }

}

object FightTeamMemberCharacterInformations extends FightTeamMemberCharacterInformations {
  case class TypeImpl(id: Int, name: String, level: Short) extends Type
  override def create(id: Int, name: String, level: Short) = TypeImpl(id, name, level)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, name: String, level: Short) = create(id, name, level)

  type Target = TypeImpl

}


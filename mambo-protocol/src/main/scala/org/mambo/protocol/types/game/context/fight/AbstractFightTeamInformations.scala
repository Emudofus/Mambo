




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AbstractFightTeamInformations extends TypeDeserializer {
  val typeId = 116

  protected trait Type extends BaseType with Serializable {
    val typeId = AbstractFightTeamInformations.typeId

    val teamId: Byte
    val leaderId: Int
    val teamSide: Byte
    val teamTypeId: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(teamId)
      buf.writeInt(leaderId)
      buf.writeByte(teamSide)
      buf.writeByte(teamTypeId)
    }

  }

  protected def create(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val teamId = buf.readByte()
    val leaderId = buf.readInt()
    val teamSide = buf.readByte()
    val teamTypeId = buf.readByte()

    create(teamId, leaderId, teamSide, teamTypeId)
  }

}

object AbstractFightTeamInformations extends AbstractFightTeamInformations {
  case class TypeImpl(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte) extends Type
  override def create(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte) = TypeImpl(teamId, leaderId, teamSide, teamTypeId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(teamId: Byte, leaderId: Int, teamSide: Byte, teamTypeId: Byte) = create(teamId, leaderId, teamSide, teamTypeId)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ProtectedEntityWaitingForHelpInfo extends TypeDeserializer {
  val typeId = 186

  protected trait Type extends BaseType with Serializable {
    val typeId = ProtectedEntityWaitingForHelpInfo.typeId

    val timeLeftBeforeFight: Int
    val waitTimeForPlacement: Int
    val nbPositionForDefensors: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(timeLeftBeforeFight)
      buf.writeInt(waitTimeForPlacement)
      buf.writeByte(nbPositionForDefensors)
    }

  }

  protected def create(timeLeftBeforeFight: Int, waitTimeForPlacement: Int, nbPositionForDefensors: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val timeLeftBeforeFight = buf.readInt()
    val waitTimeForPlacement = buf.readInt()
    val nbPositionForDefensors = buf.readByte()

    create(timeLeftBeforeFight, waitTimeForPlacement, nbPositionForDefensors)
  }

}

object ProtectedEntityWaitingForHelpInfo extends ProtectedEntityWaitingForHelpInfo {
  case class TypeImpl(timeLeftBeforeFight: Int, waitTimeForPlacement: Int, nbPositionForDefensors: Byte) extends Type
  override def create(timeLeftBeforeFight: Int, waitTimeForPlacement: Int, nbPositionForDefensors: Byte) = TypeImpl(timeLeftBeforeFight, waitTimeForPlacement, nbPositionForDefensors)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(timeLeftBeforeFight: Int, waitTimeForPlacement: Int, nbPositionForDefensors: Byte) = create(timeLeftBeforeFight, waitTimeForPlacement, nbPositionForDefensors)

  type Target = TypeImpl

}


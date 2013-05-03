




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait VillageConquestPrismInformation extends TypeDeserializer {
  val typeId = 379

  protected trait Type extends BaseType with Serializable {
    val typeId = VillageConquestPrismInformation.typeId

    val isEntered: Boolean
    val isInRoom: Boolean
    val areaId: Short
    val areaAlignment: Byte

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, isEntered)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, isInRoom)
      buf.writeUByte(flag1.toShort)
      buf.writeShort(areaId)
      buf.writeByte(areaAlignment)
    }

  }

  protected def create(isEntered: Boolean, isInRoom: Boolean, areaId: Short, areaAlignment: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val isEntered = BooleanByteWrapper.getFlag(flag1, 0)
    val isInRoom = BooleanByteWrapper.getFlag(flag1, 1)
    val areaId = buf.readShort()
    val areaAlignment = buf.readByte()

    create(isEntered, isInRoom, areaId, areaAlignment)
  }

}

object VillageConquestPrismInformation extends VillageConquestPrismInformation {
  case class TypeImpl(isEntered: Boolean, isInRoom: Boolean, areaId: Short, areaAlignment: Byte) extends Type
  override def create(isEntered: Boolean, isInRoom: Boolean, areaId: Short, areaAlignment: Byte) = TypeImpl(isEntered, isInRoom, areaId, areaAlignment)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(isEntered: Boolean, isInRoom: Boolean, areaId: Short, areaAlignment: Byte) = create(isEntered, isInRoom, areaId, areaAlignment)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameActionMarkedCell extends TypeDeserializer {
  val typeId = 85

  protected trait Type extends BaseType with Serializable {
    val typeId = GameActionMarkedCell.typeId

    val cellId: Short
    val zoneSize: Byte
    val cellColor: Int
    val cellsType: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(cellId)
      buf.writeByte(zoneSize)
      buf.writeInt(cellColor)
      buf.writeByte(cellsType)
    }

  }

  protected def create(cellId: Short, zoneSize: Byte, cellColor: Int, cellsType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val zoneSize = buf.readByte()
    val cellColor = buf.readInt()
    val cellsType = buf.readByte()

    create(cellId, zoneSize, cellColor, cellsType)
  }

}

object GameActionMarkedCell extends GameActionMarkedCell {
  case class TypeImpl(cellId: Short, zoneSize: Byte, cellColor: Int, cellsType: Byte) extends Type
  override def create(cellId: Short, zoneSize: Byte, cellColor: Int, cellsType: Byte) = TypeImpl(cellId, zoneSize, cellColor, cellsType)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cellId: Short, zoneSize: Byte, cellColor: Int, cellsType: Byte) = create(cellId, zoneSize, cellColor, cellsType)

  type Target = TypeImpl

}


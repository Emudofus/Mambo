




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PrismSubAreaInformation extends TypeDeserializer {
  val typeId = 142

  protected trait Type extends BaseType with Serializable {
    val typeId = PrismSubAreaInformation.typeId

    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short
    val alignment: Byte
    val isInFight: Boolean
    val isFightable: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
      buf.writeByte(alignment)
      buf.writeBoolean(isInFight)
      buf.writeBoolean(isFightable)
    }

  }

  protected def create(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, alignment: Byte, isInFight: Boolean, isFightable: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()
    val alignment = buf.readByte()
    val isInFight = buf.readBoolean()
    val isFightable = buf.readBoolean()

    create(worldX, worldY, mapId, subAreaId, alignment, isInFight, isFightable)
  }

}

object PrismSubAreaInformation extends PrismSubAreaInformation {
  case class TypeImpl(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, alignment: Byte, isInFight: Boolean, isFightable: Boolean) extends Type
  override def create(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, alignment: Byte, isInFight: Boolean, isFightable: Boolean) = TypeImpl(worldX, worldY, mapId, subAreaId, alignment, isInFight, isFightable)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, alignment: Byte, isInFight: Boolean, isFightable: Boolean) = create(worldX, worldY, mapId, subAreaId, alignment, isInFight, isFightable)

  type Target = TypeImpl

}


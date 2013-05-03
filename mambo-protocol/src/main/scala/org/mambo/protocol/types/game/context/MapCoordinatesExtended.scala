




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MapCoordinatesExtended extends MapCoordinatesAndId {
  override val typeId = 176

  protected trait Type extends MapCoordinatesAndId.Type with Serializable {
    override val typeId = MapCoordinatesExtended.typeId

    val subAreaId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(subAreaId)
    }

  }

  protected def create(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(worldX, worldY, mapId, subAreaId)
  }

}

object MapCoordinatesExtended extends MapCoordinatesExtended {
  case class TypeImpl(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Type
  override def create(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = TypeImpl(worldX, worldY, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(worldX, worldY, mapId, subAreaId)

  type Target = TypeImpl

}


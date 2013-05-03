




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MapCoordinatesAndId extends MapCoordinates {
  override val typeId = 392

  protected trait Type extends MapCoordinates.Type with Serializable {
    override val typeId = MapCoordinatesAndId.typeId

    val mapId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(mapId)
    }

  }

  protected def create(worldX: Short, worldY: Short, mapId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()

    create(worldX, worldY, mapId)
  }

}

object MapCoordinatesAndId extends MapCoordinatesAndId {
  case class TypeImpl(worldX: Short, worldY: Short, mapId: Int) extends Type
  override def create(worldX: Short, worldY: Short, mapId: Int) = TypeImpl(worldX, worldY, mapId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(worldX: Short, worldY: Short, mapId: Int) = create(worldX, worldY, mapId)

  type Target = TypeImpl

}


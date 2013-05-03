




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PartyMemberGeoPosition extends TypeDeserializer {
  val typeId = 378

  protected trait Type extends BaseType with Serializable {
    val typeId = PartyMemberGeoPosition.typeId

    val memberId: Int
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(memberId)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(memberId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val memberId = buf.readInt()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(memberId, worldX, worldY, mapId, subAreaId)
  }

}

object PartyMemberGeoPosition extends PartyMemberGeoPosition {
  case class TypeImpl(memberId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Type
  override def create(memberId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = TypeImpl(memberId, worldX, worldY, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(memberId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(memberId, worldX, worldY, mapId, subAreaId)

  type Target = TypeImpl

}


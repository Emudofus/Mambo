




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait TaxCollectorBasicInformations extends TypeDeserializer {
  val typeId = 96

  protected trait Type extends BaseType with Serializable {
    val typeId = TaxCollectorBasicInformations.typeId

    val firstNameId: Short
    val lastNameId: Short
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(firstNameId)
      buf.writeShort(lastNameId)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val firstNameId = buf.readShort()
    val lastNameId = buf.readShort()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(firstNameId, lastNameId, worldX, worldY, mapId, subAreaId)
  }

}

object TaxCollectorBasicInformations extends TaxCollectorBasicInformations {
  case class TypeImpl(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Type
  override def create(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = TypeImpl(firstNameId, lastNameId, worldX, worldY, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(firstNameId, lastNameId, worldX, worldY, mapId, subAreaId)

  type Target = TypeImpl

}


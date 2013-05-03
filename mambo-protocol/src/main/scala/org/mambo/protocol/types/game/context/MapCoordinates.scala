




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MapCoordinates extends TypeDeserializer {
  val typeId = 174

  protected trait Type extends BaseType with Serializable {
    val typeId = MapCoordinates.typeId

    val worldX: Short
    val worldY: Short

    def serialize(buf: Buffer) {
      buf.writeShort(worldX)
      buf.writeShort(worldY)
    }

  }

  protected def create(worldX: Short, worldY: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val worldX = buf.readShort()
    val worldY = buf.readShort()

    create(worldX, worldY)
  }

}

object MapCoordinates extends MapCoordinates {
  case class TypeImpl(worldX: Short, worldY: Short) extends Type
  override def create(worldX: Short, worldY: Short) = TypeImpl(worldX, worldY)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(worldX: Short, worldY: Short) = create(worldX, worldY)

  type Target = TypeImpl

}


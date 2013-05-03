




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait StatedElement extends TypeDeserializer {
  val typeId = 108

  protected trait Type extends BaseType with Serializable {
    val typeId = StatedElement.typeId

    val elementId: Int
    val elementCellId: Short
    val elementState: Int

    def serialize(buf: Buffer) {
      buf.writeInt(elementId)
      buf.writeShort(elementCellId)
      buf.writeInt(elementState)
    }

  }

  protected def create(elementId: Int, elementCellId: Short, elementState: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val elementId = buf.readInt()
    val elementCellId = buf.readShort()
    val elementState = buf.readInt()

    create(elementId, elementCellId, elementState)
  }

}

object StatedElement extends StatedElement {
  case class TypeImpl(elementId: Int, elementCellId: Short, elementState: Int) extends Type
  override def create(elementId: Int, elementCellId: Short, elementState: Int) = TypeImpl(elementId, elementCellId, elementState)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(elementId: Int, elementCellId: Short, elementState: Int) = create(elementId, elementCellId, elementState)

  type Target = TypeImpl

}


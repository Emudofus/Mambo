




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait EntityDispositionInformations extends TypeDeserializer {
  val typeId = 60

  protected trait Type extends BaseType with Serializable {
    val typeId = EntityDispositionInformations.typeId

    val cellId: Short
    val direction: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(cellId)
      buf.writeByte(direction)
    }

  }

  protected def create(cellId: Short, direction: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val direction = buf.readByte()

    create(cellId, direction)
  }

}

object EntityDispositionInformations extends EntityDispositionInformations {
  case class TypeImpl(cellId: Short, direction: Byte) extends Type
  override def create(cellId: Short, direction: Byte) = TypeImpl(cellId, direction)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cellId: Short, direction: Byte) = create(cellId, direction)

  type Target = TypeImpl

}


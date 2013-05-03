




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait IdentifiedEntityDispositionInformations extends EntityDispositionInformations {
  override val typeId = 107

  protected trait Type extends EntityDispositionInformations.Type with Serializable {
    override val typeId = IdentifiedEntityDispositionInformations.typeId

    val id: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(id)
    }

  }

  protected def create(cellId: Short, direction: Byte, id: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val direction = buf.readByte()
    val id = buf.readInt()

    create(cellId, direction, id)
  }

}

object IdentifiedEntityDispositionInformations extends IdentifiedEntityDispositionInformations {
  case class TypeImpl(cellId: Short, direction: Byte, id: Int) extends Type
  override def create(cellId: Short, direction: Byte, id: Int) = TypeImpl(cellId, direction, id)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cellId: Short, direction: Byte, id: Int) = create(cellId, direction, id)

  type Target = TypeImpl

}


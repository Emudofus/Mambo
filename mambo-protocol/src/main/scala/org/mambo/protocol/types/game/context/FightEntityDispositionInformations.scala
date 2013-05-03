




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightEntityDispositionInformations extends EntityDispositionInformations {
  override val typeId = 217

  protected trait Type extends EntityDispositionInformations.Type with Serializable {
    override val typeId = FightEntityDispositionInformations.typeId

    val carryingCharacterId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(carryingCharacterId)
    }

  }

  protected def create(cellId: Short, direction: Byte, carryingCharacterId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val direction = buf.readByte()
    val carryingCharacterId = buf.readInt()

    create(cellId, direction, carryingCharacterId)
  }

}

object FightEntityDispositionInformations extends FightEntityDispositionInformations {
  case class TypeImpl(cellId: Short, direction: Byte, carryingCharacterId: Int) extends Type
  override def create(cellId: Short, direction: Byte, carryingCharacterId: Int) = TypeImpl(cellId, direction, carryingCharacterId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cellId: Short, direction: Byte, carryingCharacterId: Int) = create(cellId, direction, carryingCharacterId)

  type Target = TypeImpl

}


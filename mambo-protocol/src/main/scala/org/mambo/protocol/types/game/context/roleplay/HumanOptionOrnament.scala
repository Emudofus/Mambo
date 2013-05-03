




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanOptionOrnament extends HumanOption {
  override val typeId = 411

  protected trait Type extends HumanOption.Type with Serializable {
    override val typeId = HumanOptionOrnament.typeId

    val ornamentId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(ornamentId)
    }

  }

  protected def create(ornamentId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val ornamentId = buf.readShort()

    create(ornamentId)
  }

}

object HumanOptionOrnament extends HumanOptionOrnament {
  case class TypeImpl(ornamentId: Short) extends Type
  override def create(ornamentId: Short) = TypeImpl(ornamentId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(ornamentId: Short) = create(ornamentId)

  type Target = TypeImpl

}


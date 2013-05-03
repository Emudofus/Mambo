




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GoldItem extends Item {
  override val typeId = 123

  protected trait Type extends Item.Type with Serializable {
    override val typeId = GoldItem.typeId

    val sum: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(sum)
    }

  }

  protected def create(sum: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val sum = buf.readInt()

    create(sum)
  }

}

object GoldItem extends GoldItem {
  case class TypeImpl(sum: Int) extends Type
  override def create(sum: Int) = TypeImpl(sum)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(sum: Int) = create(sum)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockBuyableInformations extends PaddockInformations {
  override val typeId = 130

  protected trait Type extends PaddockInformations.Type with Serializable {
    override val typeId = PaddockBuyableInformations.typeId

    val price: Int
    val locked: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(price)
      buf.writeBoolean(locked)
    }

  }

  protected def create(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val maxOutdoorMount = buf.readShort()
    val maxItems = buf.readShort()
    val price = buf.readInt()
    val locked = buf.readBoolean()

    create(maxOutdoorMount, maxItems, price, locked)
  }

}

object PaddockBuyableInformations extends PaddockBuyableInformations {
  case class TypeImpl(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean) extends Type
  override def create(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean) = TypeImpl(maxOutdoorMount, maxItems, price, locked)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean) = create(maxOutdoorMount, maxItems, price, locked)

  type Target = TypeImpl

}


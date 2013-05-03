




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockAbandonnedInformations extends PaddockBuyableInformations {
  override val typeId = 133

  protected trait Type extends PaddockBuyableInformations.Type with Serializable {
    override val typeId = PaddockAbandonnedInformations.typeId

    val guildId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(guildId)
    }

  }

  protected def create(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val maxOutdoorMount = buf.readShort()
    val maxItems = buf.readShort()
    val price = buf.readInt()
    val locked = buf.readBoolean()
    val guildId = buf.readInt()

    create(maxOutdoorMount, maxItems, price, locked, guildId)
  }

}

object PaddockAbandonnedInformations extends PaddockAbandonnedInformations {
  case class TypeImpl(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int) extends Type
  override def create(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int) = TypeImpl(maxOutdoorMount, maxItems, price, locked, guildId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int) = create(maxOutdoorMount, maxItems, price, locked, guildId)

  type Target = TypeImpl

}


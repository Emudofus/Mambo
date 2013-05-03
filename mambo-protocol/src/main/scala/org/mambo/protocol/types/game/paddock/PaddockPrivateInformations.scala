




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockPrivateInformations extends PaddockAbandonnedInformations {
  override val typeId = 131

  protected trait Type extends PaddockAbandonnedInformations.Type with Serializable {
    override val typeId = PaddockPrivateInformations.typeId

    val guildInfo: GuildInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guildInfo.serialize(buf)
    }

  }

  protected def create(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int, guildInfo: GuildInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val maxOutdoorMount = buf.readShort()
    val maxItems = buf.readShort()
    val price = buf.readInt()
    val locked = buf.readBoolean()
    val guildId = buf.readInt()
    val guildInfo = GuildInformations.deserialize(buf)

    create(maxOutdoorMount, maxItems, price, locked, guildId, guildInfo)
  }

}

object PaddockPrivateInformations extends PaddockPrivateInformations {
  case class TypeImpl(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int, guildInfo: GuildInformations.TypeImpl) extends Type
  override def create(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int, guildInfo: GuildInformations.TypeImpl) = TypeImpl(maxOutdoorMount, maxItems, price, locked, guildId, guildInfo)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(maxOutdoorMount: Short, maxItems: Short, price: Int, locked: Boolean, guildId: Int, guildInfo: GuildInformations.TypeImpl) = create(maxOutdoorMount, maxItems, price, locked, guildId, guildInfo)

  type Target = TypeImpl

}


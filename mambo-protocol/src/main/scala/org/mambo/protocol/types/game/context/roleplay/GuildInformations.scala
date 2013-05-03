




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GuildInformations extends BasicGuildInformations {
  override val typeId = 127

  protected trait Type extends BasicGuildInformations.Type with Serializable {
    override val typeId = GuildInformations.typeId

    val guildEmblem: GuildEmblem.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guildEmblem.serialize(buf)
    }

  }

  protected def create(guildId: Int, guildName: String, guildEmblem: GuildEmblem.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val guildId = buf.readInt()
    val guildName = buf.readString()
    val guildEmblem = GuildEmblem.deserialize(buf)

    create(guildId, guildName, guildEmblem)
  }

}

object GuildInformations extends GuildInformations {
  case class TypeImpl(guildId: Int, guildName: String, guildEmblem: GuildEmblem.TypeImpl) extends Type
  override def create(guildId: Int, guildName: String, guildEmblem: GuildEmblem.TypeImpl) = TypeImpl(guildId, guildName, guildEmblem)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(guildId: Int, guildName: String, guildEmblem: GuildEmblem.TypeImpl) = create(guildId, guildName, guildEmblem)

  type Target = TypeImpl

}


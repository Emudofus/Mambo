




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanOptionGuild extends HumanOption {
  override val typeId = 409

  protected trait Type extends HumanOption.Type with Serializable {
    override val typeId = HumanOptionGuild.typeId

    val guildInformations: GuildInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guildInformations.serialize(buf)
    }

  }

  protected def create(guildInformations: GuildInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val guildInformations = GuildInformations.deserialize(buf)

    create(guildInformations)
  }

}

object HumanOptionGuild extends HumanOptionGuild {
  case class TypeImpl(guildInformations: GuildInformations.TypeImpl) extends Type
  override def create(guildInformations: GuildInformations.TypeImpl) = TypeImpl(guildInformations)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(guildInformations: GuildInformations.TypeImpl) = create(guildInformations)

  type Target = TypeImpl

}


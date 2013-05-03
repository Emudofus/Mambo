




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanWithGuildInformations extends HumanInformations {
  override val typeId = 153

  protected trait Type extends HumanInformations.Type with Serializable {
    override val typeId = HumanWithGuildInformations.typeId

    val guildInformations: GuildInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guildInformations.serialize(buf)
    }

  }

  protected def create(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl], guildInformations: GuildInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val restrictions = ActorRestrictionsInformations.deserialize(buf)
    val sex = buf.readBoolean()
    val options = {
      val builder = collection.immutable.Seq.newBuilder[HumanOption.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[HumanOption.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val guildInformations = GuildInformations.deserialize(buf)

    create(restrictions, sex, options, guildInformations)
  }

}

object HumanWithGuildInformations extends HumanWithGuildInformations {
  case class TypeImpl(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl], guildInformations: GuildInformations.TypeImpl) extends Type
  override def create(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl], guildInformations: GuildInformations.TypeImpl) = TypeImpl(restrictions, sex, options, guildInformations)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl], guildInformations: GuildInformations.TypeImpl) = create(restrictions, sex, options, guildInformations)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayMerchantWithGuildInformations extends GameRolePlayMerchantInformations {
  override val typeId = 146

  protected trait Type extends GameRolePlayMerchantInformations.Type with Serializable {
    override val typeId = GameRolePlayMerchantWithGuildInformations.typeId

    val guildInformations: GuildInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guildInformations.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int, guildInformations: GuildInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()
    val sellType = buf.readInt()
    val guildInformations = GuildInformations.deserialize(buf)

    create(contextualId, look, disposition, name, sellType, guildInformations)
  }

}

object GameRolePlayMerchantWithGuildInformations extends GameRolePlayMerchantWithGuildInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int, guildInformations: GuildInformations.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int, guildInformations: GuildInformations.TypeImpl) = TypeImpl(contextualId, look, disposition, name, sellType, guildInformations)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int, guildInformations: GuildInformations.TypeImpl) = create(contextualId, look, disposition, name, sellType, guildInformations)

  type Target = TypeImpl

}


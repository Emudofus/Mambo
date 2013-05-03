




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayTaxCollectorInformations extends GameRolePlayActorInformations {
  override val typeId = 148

  protected trait Type extends GameRolePlayActorInformations.Type with Serializable {
    override val typeId = GameRolePlayTaxCollectorInformations.typeId

    val firstNameId: Short
    val lastNameId: Short
    val guildIdentity: GuildInformations.TypeImpl
    val guildLevel: UByte
    val taxCollectorAttack: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(firstNameId)
      buf.writeShort(lastNameId)
      guildIdentity.serialize(buf)
      buf.writeUByte(guildLevel)
      buf.writeInt(taxCollectorAttack)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, firstNameId: Short, lastNameId: Short, guildIdentity: GuildInformations.TypeImpl, guildLevel: UByte, taxCollectorAttack: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val firstNameId = buf.readShort()
    val lastNameId = buf.readShort()
    val guildIdentity = GuildInformations.deserialize(buf)
    val guildLevel = buf.readUByte()
    val taxCollectorAttack = buf.readInt()

    create(contextualId, look, disposition, firstNameId, lastNameId, guildIdentity, guildLevel, taxCollectorAttack)
  }

}

object GameRolePlayTaxCollectorInformations extends GameRolePlayTaxCollectorInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, firstNameId: Short, lastNameId: Short, guildIdentity: GuildInformations.TypeImpl, guildLevel: UByte, taxCollectorAttack: Int) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, firstNameId: Short, lastNameId: Short, guildIdentity: GuildInformations.TypeImpl, guildLevel: UByte, taxCollectorAttack: Int) = TypeImpl(contextualId, look, disposition, firstNameId, lastNameId, guildIdentity, guildLevel, taxCollectorAttack)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, firstNameId: Short, lastNameId: Short, guildIdentity: GuildInformations.TypeImpl, guildLevel: UByte, taxCollectorAttack: Int) = create(contextualId, look, disposition, firstNameId, lastNameId, guildIdentity, guildLevel, taxCollectorAttack)

  type Target = TypeImpl

}


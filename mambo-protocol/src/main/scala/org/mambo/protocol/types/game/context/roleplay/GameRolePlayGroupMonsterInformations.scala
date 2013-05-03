




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayGroupMonsterInformations extends GameRolePlayActorInformations {
  override val typeId = 160

  protected trait Type extends GameRolePlayActorInformations.Type with Serializable {
    override val typeId = GameRolePlayGroupMonsterInformations.typeId

    val staticInfos: GroupMonsterStaticInformations.TypeImpl
    val ageBonus: Short
    val lootShare: Byte
    val alignmentSide: Byte
    val keyRingBonus: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(staticInfos.typeId)
      staticInfos.serialize(buf)
      buf.writeShort(ageBonus)
      buf.writeByte(lootShare)
      buf.writeByte(alignmentSide)
      buf.writeBoolean(keyRingBonus)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, staticInfos: GroupMonsterStaticInformations.TypeImpl, ageBonus: Short, lootShare: Byte, alignmentSide: Byte, keyRingBonus: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val staticInfos = types.get[GroupMonsterStaticInformations.TypeImpl](buf.readShort());
    val ageBonus = buf.readShort()
    val lootShare = buf.readByte()
    val alignmentSide = buf.readByte()
    val keyRingBonus = buf.readBoolean()

    create(contextualId, look, disposition, staticInfos, ageBonus, lootShare, alignmentSide, keyRingBonus)
  }

}

object GameRolePlayGroupMonsterInformations extends GameRolePlayGroupMonsterInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, staticInfos: GroupMonsterStaticInformations.TypeImpl, ageBonus: Short, lootShare: Byte, alignmentSide: Byte, keyRingBonus: Boolean) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, staticInfos: GroupMonsterStaticInformations.TypeImpl, ageBonus: Short, lootShare: Byte, alignmentSide: Byte, keyRingBonus: Boolean) = TypeImpl(contextualId, look, disposition, staticInfos, ageBonus, lootShare, alignmentSide, keyRingBonus)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, staticInfos: GroupMonsterStaticInformations.TypeImpl, ageBonus: Short, lootShare: Byte, alignmentSide: Byte, keyRingBonus: Boolean) = create(contextualId, look, disposition, staticInfos, ageBonus, lootShare, alignmentSide, keyRingBonus)

  type Target = TypeImpl

}


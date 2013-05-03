




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcInformations {
  override val typeId = 383

  protected trait Type extends GameRolePlayNpcInformations.Type with Serializable {
    override val typeId = GameRolePlayNpcWithQuestInformations.typeId

    val questFlag: GameRolePlayNpcQuestFlag.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      questFlag.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short, questFlag: GameRolePlayNpcQuestFlag.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val npcId = buf.readShort()
    val sex = buf.readBoolean()
    val specialArtworkId = buf.readShort()
    val questFlag = GameRolePlayNpcQuestFlag.deserialize(buf)

    create(contextualId, look, disposition, npcId, sex, specialArtworkId, questFlag)
  }

}

object GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcWithQuestInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short, questFlag: GameRolePlayNpcQuestFlag.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short, questFlag: GameRolePlayNpcQuestFlag.TypeImpl) = TypeImpl(contextualId, look, disposition, npcId, sex, specialArtworkId, questFlag)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short, questFlag: GameRolePlayNpcQuestFlag.TypeImpl) = create(contextualId, look, disposition, npcId, sex, specialArtworkId, questFlag)

  type Target = TypeImpl

}


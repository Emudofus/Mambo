




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayNpcInformations extends GameRolePlayActorInformations {
  override val typeId = 156

  protected trait Type extends GameRolePlayActorInformations.Type with Serializable {
    override val typeId = GameRolePlayNpcInformations.typeId

    val npcId: Short
    val sex: Boolean
    val specialArtworkId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(npcId)
      buf.writeBoolean(sex)
      buf.writeShort(specialArtworkId)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val npcId = buf.readShort()
    val sex = buf.readBoolean()
    val specialArtworkId = buf.readShort()

    create(contextualId, look, disposition, npcId, sex, specialArtworkId)
  }

}

object GameRolePlayNpcInformations extends GameRolePlayNpcInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short) = TypeImpl(contextualId, look, disposition, npcId, sex, specialArtworkId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, npcId: Short, sex: Boolean, specialArtworkId: Short) = create(contextualId, look, disposition, npcId, sex, specialArtworkId)

  type Target = TypeImpl

}


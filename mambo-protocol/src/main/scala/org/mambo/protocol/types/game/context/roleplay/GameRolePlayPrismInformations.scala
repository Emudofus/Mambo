




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayPrismInformations extends GameRolePlayActorInformations {
  override val typeId = 161

  protected trait Type extends GameRolePlayActorInformations.Type with Serializable {
    override val typeId = GameRolePlayPrismInformations.typeId

    val alignInfos: ActorAlignmentInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      alignInfos.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, alignInfos: ActorAlignmentInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val alignInfos = ActorAlignmentInformations.deserialize(buf)

    create(contextualId, look, disposition, alignInfos)
  }

}

object GameRolePlayPrismInformations extends GameRolePlayPrismInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, alignInfos: ActorAlignmentInformations.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, alignInfos: ActorAlignmentInformations.TypeImpl) = TypeImpl(contextualId, look, disposition, alignInfos)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, alignInfos: ActorAlignmentInformations.TypeImpl) = create(contextualId, look, disposition, alignInfos)

  type Target = TypeImpl

}


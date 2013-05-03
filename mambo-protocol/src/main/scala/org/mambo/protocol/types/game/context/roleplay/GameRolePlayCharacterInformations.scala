




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayCharacterInformations extends GameRolePlayHumanoidInformations {
  override val typeId = 36

  protected trait Type extends GameRolePlayHumanoidInformations.Type with Serializable {
    override val typeId = GameRolePlayCharacterInformations.typeId

    val alignmentInfos: ActorAlignmentInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      alignmentInfos.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, alignmentInfos: ActorAlignmentInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()
    val humanoidInfo = types.get[HumanInformations.TypeImpl](buf.readShort());
    val accountId = buf.readInt()
    val alignmentInfos = ActorAlignmentInformations.deserialize(buf)

    create(contextualId, look, disposition, name, humanoidInfo, accountId, alignmentInfos)
  }

}

object GameRolePlayCharacterInformations extends GameRolePlayCharacterInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, alignmentInfos: ActorAlignmentInformations.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, alignmentInfos: ActorAlignmentInformations.TypeImpl) = TypeImpl(contextualId, look, disposition, name, humanoidInfo, accountId, alignmentInfos)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, alignmentInfos: ActorAlignmentInformations.TypeImpl) = create(contextualId, look, disposition, name, humanoidInfo, accountId, alignmentInfos)

  type Target = TypeImpl

}


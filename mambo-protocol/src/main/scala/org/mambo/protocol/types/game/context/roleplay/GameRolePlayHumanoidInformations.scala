




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations {
  override val typeId = 159

  protected trait Type extends GameRolePlayNamedActorInformations.Type with Serializable {
    override val typeId = GameRolePlayHumanoidInformations.typeId

    val humanoidInfo: HumanInformations.TypeImpl
    val accountId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(humanoidInfo.typeId)
      humanoidInfo.serialize(buf)
      buf.writeInt(accountId)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()
    val humanoidInfo = types.get[HumanInformations.TypeImpl](buf.readShort());
    val accountId = buf.readInt()

    create(contextualId, look, disposition, name, humanoidInfo, accountId)
  }

}

object GameRolePlayHumanoidInformations extends GameRolePlayHumanoidInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int) = TypeImpl(contextualId, look, disposition, name, humanoidInfo, accountId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int) = create(contextualId, look, disposition, name, humanoidInfo, accountId)

  type Target = TypeImpl

}


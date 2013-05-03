




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayMutantInformations extends GameRolePlayHumanoidInformations {
  override val typeId = 3

  protected trait Type extends GameRolePlayHumanoidInformations.Type with Serializable {
    override val typeId = GameRolePlayMutantInformations.typeId

    val monsterId: Int
    val powerLevel: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(monsterId)
      buf.writeByte(powerLevel)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, monsterId: Int, powerLevel: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()
    val humanoidInfo = types.get[HumanInformations.TypeImpl](buf.readShort());
    val accountId = buf.readInt()
    val monsterId = buf.readInt()
    val powerLevel = buf.readByte()

    create(contextualId, look, disposition, name, humanoidInfo, accountId, monsterId, powerLevel)
  }

}

object GameRolePlayMutantInformations extends GameRolePlayMutantInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, monsterId: Int, powerLevel: Byte) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, monsterId: Int, powerLevel: Byte) = TypeImpl(contextualId, look, disposition, name, humanoidInfo, accountId, monsterId, powerLevel)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, humanoidInfo: HumanInformations.TypeImpl, accountId: Int, monsterId: Int, powerLevel: Byte) = create(contextualId, look, disposition, name, humanoidInfo, accountId, monsterId, powerLevel)

  type Target = TypeImpl

}


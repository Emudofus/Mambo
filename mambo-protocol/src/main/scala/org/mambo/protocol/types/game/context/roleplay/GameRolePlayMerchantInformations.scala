




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayMerchantInformations extends GameRolePlayNamedActorInformations {
  override val typeId = 129

  protected trait Type extends GameRolePlayNamedActorInformations.Type with Serializable {
    override val typeId = GameRolePlayMerchantInformations.typeId

    val sellType: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(sellType)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()
    val sellType = buf.readInt()

    create(contextualId, look, disposition, name, sellType)
  }

}

object GameRolePlayMerchantInformations extends GameRolePlayMerchantInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int) = TypeImpl(contextualId, look, disposition, name, sellType)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, sellType: Int) = create(contextualId, look, disposition, name, sellType)

  type Target = TypeImpl

}


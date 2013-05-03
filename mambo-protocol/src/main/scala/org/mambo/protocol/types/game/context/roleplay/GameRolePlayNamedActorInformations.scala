




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayNamedActorInformations extends GameRolePlayActorInformations {
  override val typeId = 154

  protected trait Type extends GameRolePlayActorInformations.Type with Serializable {
    override val typeId = GameRolePlayNamedActorInformations.typeId

    val name: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()

    create(contextualId, look, disposition, name)
  }

}

object GameRolePlayNamedActorInformations extends GameRolePlayNamedActorInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String) = TypeImpl(contextualId, look, disposition, name)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String) = create(contextualId, look, disposition, name)

  type Target = TypeImpl

}


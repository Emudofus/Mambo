




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayMountInformations extends GameRolePlayNamedActorInformations {
  override val typeId = 180

  protected trait Type extends GameRolePlayNamedActorInformations.Type with Serializable {
    override val typeId = GameRolePlayMountInformations.typeId

    val ownerName: String
    val level: UByte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(ownerName)
      buf.writeUByte(level)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, ownerName: String, level: UByte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val name = buf.readString()
    val ownerName = buf.readString()
    val level = buf.readUByte()

    create(contextualId, look, disposition, name, ownerName, level)
  }

}

object GameRolePlayMountInformations extends GameRolePlayMountInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, ownerName: String, level: UByte) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, ownerName: String, level: UByte) = TypeImpl(contextualId, look, disposition, name, ownerName, level)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, name: String, ownerName: String, level: UByte) = create(contextualId, look, disposition, name, ownerName, level)

  type Target = TypeImpl

}


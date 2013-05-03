




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameContextActorInformations extends TypeDeserializer {
  val typeId = 150

  protected trait Type extends BaseType with Serializable {
    val typeId = GameContextActorInformations.typeId

    val contextualId: Int
    val look: EntityLook.TypeImpl
    val disposition: EntityDispositionInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeInt(contextualId)
      look.serialize(buf)
      buf.writeUShort(disposition.typeId)
      disposition.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());

    create(contextualId, look, disposition)
  }

}

object GameContextActorInformations extends GameContextActorInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl) = TypeImpl(contextualId, look, disposition)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl) = create(contextualId, look, disposition)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightFighterNamedInformations extends GameFightFighterInformations {
  override val typeId = 158

  protected trait Type extends GameFightFighterInformations.Type with Serializable {
    override val typeId = GameFightFighterNamedInformations.typeId

    val name: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());
    val name = buf.readString()

    create(contextualId, look, disposition, teamId, alive, stats, name)
  }

}

object GameFightFighterNamedInformations extends GameFightFighterNamedInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String) = TypeImpl(contextualId, look, disposition, teamId, alive, stats, name)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String) = create(contextualId, look, disposition, teamId, alive, stats, name)

  type Target = TypeImpl

}


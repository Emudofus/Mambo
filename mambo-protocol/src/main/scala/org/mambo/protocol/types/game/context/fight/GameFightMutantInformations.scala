




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightMutantInformations extends GameFightFighterNamedInformations {
  override val typeId = 50

  protected trait Type extends GameFightFighterNamedInformations.Type with Serializable {
    override val typeId = GameFightMutantInformations.typeId

    val powerLevel: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(powerLevel)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, powerLevel: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());
    val name = buf.readString()
    val powerLevel = buf.readByte()

    create(contextualId, look, disposition, teamId, alive, stats, name, powerLevel)
  }

}

object GameFightMutantInformations extends GameFightMutantInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, powerLevel: Byte) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, powerLevel: Byte) = TypeImpl(contextualId, look, disposition, teamId, alive, stats, name, powerLevel)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, powerLevel: Byte) = create(contextualId, look, disposition, teamId, alive, stats, name, powerLevel)

  type Target = TypeImpl

}


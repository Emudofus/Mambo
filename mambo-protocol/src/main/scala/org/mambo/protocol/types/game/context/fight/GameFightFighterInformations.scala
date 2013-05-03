




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightFighterInformations extends GameContextActorInformations {
  override val typeId = 143

  protected trait Type extends GameContextActorInformations.Type with Serializable {
    override val typeId = GameFightFighterInformations.typeId

    val teamId: Byte
    val alive: Boolean
    val stats: GameFightMinimalStats.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(teamId)
      buf.writeBoolean(alive)
      buf.writeUShort(stats.typeId)
      stats.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());

    create(contextualId, look, disposition, teamId, alive, stats)
  }

}

object GameFightFighterInformations extends GameFightFighterInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl) = TypeImpl(contextualId, look, disposition, teamId, alive, stats)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl) = create(contextualId, look, disposition, teamId, alive, stats)

  type Target = TypeImpl

}


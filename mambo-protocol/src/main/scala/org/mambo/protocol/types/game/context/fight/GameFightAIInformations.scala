




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightAIInformations extends GameFightFighterInformations {
  override val typeId = 151

  protected trait Type extends GameFightFighterInformations.Type with Serializable {
    override val typeId = GameFightAIInformations.typeId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

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

object GameFightAIInformations extends GameFightAIInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl) = TypeImpl(contextualId, look, disposition, teamId, alive, stats)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl) = create(contextualId, look, disposition, teamId, alive, stats)

  type Target = TypeImpl

}


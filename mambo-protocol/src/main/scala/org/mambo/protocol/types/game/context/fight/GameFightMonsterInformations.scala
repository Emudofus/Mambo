




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightMonsterInformations extends GameFightAIInformations {
  override val typeId = 29

  protected trait Type extends GameFightAIInformations.Type with Serializable {
    override val typeId = GameFightMonsterInformations.typeId

    val creatureGenericId: Short
    val creatureGrade: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(creatureGenericId)
      buf.writeByte(creatureGrade)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());
    val creatureGenericId = buf.readShort()
    val creatureGrade = buf.readByte()

    create(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade)
  }

}

object GameFightMonsterInformations extends GameFightMonsterInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte) = TypeImpl(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte) = create(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade)

  type Target = TypeImpl

}


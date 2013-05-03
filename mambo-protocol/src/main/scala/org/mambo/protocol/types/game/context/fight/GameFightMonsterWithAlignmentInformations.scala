




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightMonsterWithAlignmentInformations extends GameFightMonsterInformations {
  override val typeId = 203

  protected trait Type extends GameFightMonsterInformations.Type with Serializable {
    override val typeId = GameFightMonsterWithAlignmentInformations.typeId

    val alignmentInfos: ActorAlignmentInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      alignmentInfos.serialize(buf)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte, alignmentInfos: ActorAlignmentInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());
    val creatureGenericId = buf.readShort()
    val creatureGrade = buf.readByte()
    val alignmentInfos = ActorAlignmentInformations.deserialize(buf)

    create(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade, alignmentInfos)
  }

}

object GameFightMonsterWithAlignmentInformations extends GameFightMonsterWithAlignmentInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte, alignmentInfos: ActorAlignmentInformations.TypeImpl) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte, alignmentInfos: ActorAlignmentInformations.TypeImpl) = TypeImpl(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade, alignmentInfos)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, creatureGenericId: Short, creatureGrade: Byte, alignmentInfos: ActorAlignmentInformations.TypeImpl) = create(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade, alignmentInfos)

  type Target = TypeImpl

}


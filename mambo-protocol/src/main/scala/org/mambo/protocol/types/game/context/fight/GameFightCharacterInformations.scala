




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightCharacterInformations extends GameFightFighterNamedInformations {
  override val typeId = 46

  protected trait Type extends GameFightFighterNamedInformations.Type with Serializable {
    override val typeId = GameFightCharacterInformations.typeId

    val level: Short
    val alignmentInfos: ActorAlignmentInformations.TypeImpl
    val breed: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(level)
      alignmentInfos.serialize(buf)
      buf.writeByte(breed)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, level: Short, alignmentInfos: ActorAlignmentInformations.TypeImpl, breed: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());
    val name = buf.readString()
    val level = buf.readShort()
    val alignmentInfos = ActorAlignmentInformations.deserialize(buf)
    val breed = buf.readByte()

    create(contextualId, look, disposition, teamId, alive, stats, name, level, alignmentInfos, breed)
  }

}

object GameFightCharacterInformations extends GameFightCharacterInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, level: Short, alignmentInfos: ActorAlignmentInformations.TypeImpl, breed: Byte) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, level: Short, alignmentInfos: ActorAlignmentInformations.TypeImpl, breed: Byte) = TypeImpl(contextualId, look, disposition, teamId, alive, stats, name, level, alignmentInfos, breed)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, name: String, level: Short, alignmentInfos: ActorAlignmentInformations.TypeImpl, breed: Byte) = create(contextualId, look, disposition, teamId, alive, stats, name, level, alignmentInfos, breed)

  type Target = TypeImpl

}


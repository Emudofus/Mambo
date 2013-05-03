




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightTaxCollectorInformations extends GameFightAIInformations {
  override val typeId = 48

  protected trait Type extends GameFightAIInformations.Type with Serializable {
    override val typeId = GameFightTaxCollectorInformations.typeId

    val firstNameId: Short
    val lastNameId: Short
    val level: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(firstNameId)
      buf.writeShort(lastNameId)
      buf.writeShort(level)
    }

  }

  protected def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, firstNameId: Short, lastNameId: Short, level: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val contextualId = buf.readInt()
    val look = EntityLook.deserialize(buf)
    val disposition = types.get[EntityDispositionInformations.TypeImpl](buf.readShort());
    val teamId = buf.readByte()
    val alive = buf.readBoolean()
    val stats = types.get[GameFightMinimalStats.TypeImpl](buf.readShort());
    val firstNameId = buf.readShort()
    val lastNameId = buf.readShort()
    val level = buf.readShort()

    create(contextualId, look, disposition, teamId, alive, stats, firstNameId, lastNameId, level)
  }

}

object GameFightTaxCollectorInformations extends GameFightTaxCollectorInformations {
  case class TypeImpl(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, firstNameId: Short, lastNameId: Short, level: Short) extends Type
  override def create(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, firstNameId: Short, lastNameId: Short, level: Short) = TypeImpl(contextualId, look, disposition, teamId, alive, stats, firstNameId, lastNameId, level)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(contextualId: Int, look: EntityLook.TypeImpl, disposition: EntityDispositionInformations.TypeImpl, teamId: Byte, alive: Boolean, stats: GameFightMinimalStats.TypeImpl, firstNameId: Short, lastNameId: Short, level: Short) = create(contextualId, look, disposition, teamId, alive, stats, firstNameId, lastNameId, level)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightSpellCooldown extends TypeDeserializer {
  val typeId = 205

  protected trait Type extends BaseType with Serializable {
    val typeId = GameFightSpellCooldown.typeId

    val spellId: Int
    val cooldown: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(spellId)
      buf.writeByte(cooldown)
    }

  }

  protected def create(spellId: Int, cooldown: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellId = buf.readInt()
    val cooldown = buf.readByte()

    create(spellId, cooldown)
  }

}

object GameFightSpellCooldown extends GameFightSpellCooldown {
  case class TypeImpl(spellId: Int, cooldown: Byte) extends Type
  override def create(spellId: Int, cooldown: Byte) = TypeImpl(spellId, cooldown)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(spellId: Int, cooldown: Byte) = create(spellId, cooldown)

  type Target = TypeImpl

}


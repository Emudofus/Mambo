




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ShortcutSpell extends Shortcut {
  override val typeId = 368

  protected trait Type extends Shortcut.Type with Serializable {
    override val typeId = ShortcutSpell.typeId

    val spellId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(spellId)
    }

  }

  protected def create(slot: Int, spellId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val slot = buf.readInt()
    val spellId = buf.readShort()

    create(slot, spellId)
  }

}

object ShortcutSpell extends ShortcutSpell {
  case class TypeImpl(slot: Int, spellId: Short) extends Type
  override def create(slot: Int, spellId: Short) = TypeImpl(slot, spellId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int, spellId: Short) = create(slot, spellId)

  type Target = TypeImpl

}


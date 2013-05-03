




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ShortcutSmiley extends Shortcut {
  override val typeId = 388

  protected trait Type extends Shortcut.Type with Serializable {
    override val typeId = ShortcutSmiley.typeId

    val smileyId: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(smileyId)
    }

  }

  protected def create(slot: Int, smileyId: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val slot = buf.readInt()
    val smileyId = buf.readByte()

    create(slot, smileyId)
  }

}

object ShortcutSmiley extends ShortcutSmiley {
  case class TypeImpl(slot: Int, smileyId: Byte) extends Type
  override def create(slot: Int, smileyId: Byte) = TypeImpl(slot, smileyId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int, smileyId: Byte) = create(slot, smileyId)

  type Target = TypeImpl

}


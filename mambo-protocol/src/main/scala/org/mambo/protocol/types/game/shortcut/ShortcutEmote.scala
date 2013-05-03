




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ShortcutEmote extends Shortcut {
  override val typeId = 389

  protected trait Type extends Shortcut.Type with Serializable {
    override val typeId = ShortcutEmote.typeId

    val emoteId: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(emoteId)
    }

  }

  protected def create(slot: Int, emoteId: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val slot = buf.readInt()
    val emoteId = buf.readByte()

    create(slot, emoteId)
  }

}

object ShortcutEmote extends ShortcutEmote {
  case class TypeImpl(slot: Int, emoteId: Byte) extends Type
  override def create(slot: Int, emoteId: Byte) = TypeImpl(slot, emoteId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int, emoteId: Byte) = create(slot, emoteId)

  type Target = TypeImpl

}


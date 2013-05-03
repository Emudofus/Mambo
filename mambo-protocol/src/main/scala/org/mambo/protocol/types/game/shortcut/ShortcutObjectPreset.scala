




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ShortcutObjectPreset extends ShortcutObject {
  override val typeId = 370

  protected trait Type extends ShortcutObject.Type with Serializable {
    override val typeId = ShortcutObjectPreset.typeId

    val presetId: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(presetId)
    }

  }

  protected def create(slot: Int, presetId: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val slot = buf.readInt()
    val presetId = buf.readByte()

    create(slot, presetId)
  }

}

object ShortcutObjectPreset extends ShortcutObjectPreset {
  case class TypeImpl(slot: Int, presetId: Byte) extends Type
  override def create(slot: Int, presetId: Byte) = TypeImpl(slot, presetId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int, presetId: Byte) = create(slot, presetId)

  type Target = TypeImpl

}


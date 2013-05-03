




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SpellItem extends Item {
  override val typeId = 49

  protected trait Type extends Item.Type with Serializable {
    override val typeId = SpellItem.typeId

    val position: UByte
    val spellId: Int
    val spellLevel: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(position)
      buf.writeInt(spellId)
      buf.writeByte(spellLevel)
    }

  }

  protected def create(position: UByte, spellId: Int, spellLevel: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val position = buf.readUByte()
    val spellId = buf.readInt()
    val spellLevel = buf.readByte()

    create(position, spellId, spellLevel)
  }

}

object SpellItem extends SpellItem {
  case class TypeImpl(position: UByte, spellId: Int, spellLevel: Byte) extends Type
  override def create(position: UByte, spellId: Int, spellLevel: Byte) = TypeImpl(position, spellId, spellLevel)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(position: UByte, spellId: Int, spellLevel: Byte) = create(position, spellId, spellLevel)

  type Target = TypeImpl

}


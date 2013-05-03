




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ShortcutObjectItem extends ShortcutObject {
  override val typeId = 371

  protected trait Type extends ShortcutObject.Type with Serializable {
    override val typeId = ShortcutObjectItem.typeId

    val itemUID: Int
    val itemGID: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(itemUID)
      buf.writeInt(itemGID)
    }

  }

  protected def create(slot: Int, itemUID: Int, itemGID: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val slot = buf.readInt()
    val itemUID = buf.readInt()
    val itemGID = buf.readInt()

    create(slot, itemUID, itemGID)
  }

}

object ShortcutObjectItem extends ShortcutObjectItem {
  case class TypeImpl(slot: Int, itemUID: Int, itemGID: Int) extends Type
  override def create(slot: Int, itemUID: Int, itemGID: Int) = TypeImpl(slot, itemUID, itemGID)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int, itemUID: Int, itemGID: Int) = create(slot, itemUID, itemGID)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockItem extends ObjectItemInRolePlay {
  override val typeId = 185

  protected trait Type extends ObjectItemInRolePlay.Type with Serializable {
    override val typeId = PaddockItem.typeId

    val durability: ItemDurability.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      durability.serialize(buf)
    }

  }

  protected def create(cellId: Short, objectGID: Short, durability: ItemDurability.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val objectGID = buf.readShort()
    val durability = ItemDurability.deserialize(buf)

    create(cellId, objectGID, durability)
  }

}

object PaddockItem extends PaddockItem {
  case class TypeImpl(cellId: Short, objectGID: Short, durability: ItemDurability.TypeImpl) extends Type
  override def create(cellId: Short, objectGID: Short, durability: ItemDurability.TypeImpl) = TypeImpl(cellId, objectGID, durability)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cellId: Short, objectGID: Short, durability: ItemDurability.TypeImpl) = create(cellId, objectGID, durability)

  type Target = TypeImpl

}


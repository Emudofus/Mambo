




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ItemDurability extends TypeDeserializer {
  val typeId = 168

  protected trait Type extends BaseType with Serializable {
    val typeId = ItemDurability.typeId

    val durability: Short
    val durabilityMax: Short

    def serialize(buf: Buffer) {
      buf.writeShort(durability)
      buf.writeShort(durabilityMax)
    }

  }

  protected def create(durability: Short, durabilityMax: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val durability = buf.readShort()
    val durabilityMax = buf.readShort()

    create(durability, durabilityMax)
  }

}

object ItemDurability extends ItemDurability {
  case class TypeImpl(durability: Short, durabilityMax: Short) extends Type
  override def create(durability: Short, durabilityMax: Short) = TypeImpl(durability, durabilityMax)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(durability: Short, durabilityMax: Short) = create(durability, durabilityMax)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemQuantity extends Item {
  override val typeId = 119

  protected trait Type extends Item.Type with Serializable {
    override val typeId = ObjectItemQuantity.typeId

    val objectUID: Int
    val quantity: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(objectUID)
      buf.writeInt(quantity)
    }

  }

  protected def create(objectUID: Int, quantity: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val quantity = buf.readInt()

    create(objectUID, quantity)
  }

}

object ObjectItemQuantity extends ObjectItemQuantity {
  case class TypeImpl(objectUID: Int, quantity: Int) extends Type
  override def create(objectUID: Int, quantity: Int) = TypeImpl(objectUID, quantity)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectUID: Int, quantity: Int) = create(objectUID, quantity)

  type Target = TypeImpl

}


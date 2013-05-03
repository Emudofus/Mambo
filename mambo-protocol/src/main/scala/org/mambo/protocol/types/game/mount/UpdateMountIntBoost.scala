




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait UpdateMountIntBoost extends UpdateMountBoost {
  override val typeId = 357

  protected trait Type extends UpdateMountBoost.Type with Serializable {
    override val typeId = UpdateMountIntBoost.typeId

    val value: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(value)
    }

  }

  protected def create(theType: Byte, value: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val theType = buf.readByte()
    val value = buf.readInt()

    create(theType, value)
  }

}

object UpdateMountIntBoost extends UpdateMountIntBoost {
  case class TypeImpl(theType: Byte, value: Int) extends Type
  override def create(theType: Byte, value: Int) = TypeImpl(theType, value)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(theType: Byte, value: Int) = create(theType, value)

  type Target = TypeImpl

}


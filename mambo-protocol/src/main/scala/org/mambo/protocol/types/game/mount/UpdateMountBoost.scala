




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait UpdateMountBoost extends TypeDeserializer {
  val typeId = 356

  protected trait Type extends BaseType with Serializable {
    val typeId = UpdateMountBoost.typeId

    val theType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(theType)
    }

  }

  protected def create(theType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = buf.readByte()

    create(theType)
  }

}

object UpdateMountBoost extends UpdateMountBoost {
  case class TypeImpl(theType: Byte) extends Type
  override def create(theType: Byte) = TypeImpl(theType)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(theType: Byte) = create(theType)

  type Target = TypeImpl

}


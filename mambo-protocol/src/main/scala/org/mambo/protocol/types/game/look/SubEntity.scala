




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SubEntity extends TypeDeserializer {
  val typeId = 54

  protected trait Type extends BaseType with Serializable {
    val typeId = SubEntity.typeId

    val bindingPointCategory: Byte
    val bindingPointIndex: Byte
    val subEntityLook: EntityLook.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeByte(bindingPointCategory)
      buf.writeByte(bindingPointIndex)
      subEntityLook.serialize(buf)
    }

  }

  protected def create(bindingPointCategory: Byte, bindingPointIndex: Byte, subEntityLook: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val bindingPointCategory = buf.readByte()
    val bindingPointIndex = buf.readByte()
    val subEntityLook = EntityLook.deserialize(buf)

    create(bindingPointCategory, bindingPointIndex, subEntityLook)
  }

}

object SubEntity extends SubEntity {
  case class TypeImpl(bindingPointCategory: Byte, bindingPointIndex: Byte, subEntityLook: EntityLook.TypeImpl) extends Type
  override def create(bindingPointCategory: Byte, bindingPointIndex: Byte, subEntityLook: EntityLook.TypeImpl) = TypeImpl(bindingPointCategory, bindingPointIndex, subEntityLook)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(bindingPointCategory: Byte, bindingPointIndex: Byte, subEntityLook: EntityLook.TypeImpl) = create(bindingPointCategory, bindingPointIndex, subEntityLook)

  type Target = TypeImpl

}


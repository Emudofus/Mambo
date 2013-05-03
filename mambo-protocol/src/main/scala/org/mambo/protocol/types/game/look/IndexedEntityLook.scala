




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait IndexedEntityLook extends TypeDeserializer {
  val typeId = 405

  protected trait Type extends BaseType with Serializable {
    val typeId = IndexedEntityLook.typeId

    val look: EntityLook.TypeImpl
    val index: Byte

    def serialize(buf: Buffer) {
      look.serialize(buf)
      buf.writeByte(index)
    }

  }

  protected def create(look: EntityLook.TypeImpl, index: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val look = EntityLook.deserialize(buf)
    val index = buf.readByte()

    create(look, index)
  }

}

object IndexedEntityLook extends IndexedEntityLook {
  case class TypeImpl(look: EntityLook.TypeImpl, index: Byte) extends Type
  override def create(look: EntityLook.TypeImpl, index: Byte) = TypeImpl(look, index)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(look: EntityLook.TypeImpl, index: Byte) = create(look, index)

  type Target = TypeImpl

}


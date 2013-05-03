




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemInRolePlay extends TypeDeserializer {
  val typeId = 198

  protected trait Type extends BaseType with Serializable {
    val typeId = ObjectItemInRolePlay.typeId

    val cellId: Short
    val objectGID: Short

    def serialize(buf: Buffer) {
      buf.writeShort(cellId)
      buf.writeShort(objectGID)
    }

  }

  protected def create(cellId: Short, objectGID: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val objectGID = buf.readShort()

    create(cellId, objectGID)
  }

}

object ObjectItemInRolePlay extends ObjectItemInRolePlay {
  case class TypeImpl(cellId: Short, objectGID: Short) extends Type
  override def create(cellId: Short, objectGID: Short) = TypeImpl(cellId, objectGID)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cellId: Short, objectGID: Short) = create(cellId, objectGID)

  type Target = TypeImpl

}


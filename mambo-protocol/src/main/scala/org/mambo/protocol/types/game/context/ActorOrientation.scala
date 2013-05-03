




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ActorOrientation extends TypeDeserializer {
  val typeId = 353

  protected trait Type extends BaseType with Serializable {
    val typeId = ActorOrientation.typeId

    val id: Int
    val direction: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      buf.writeByte(direction)
    }

  }

  protected def create(id: Int, direction: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val direction = buf.readByte()

    create(id, direction)
  }

}

object ActorOrientation extends ActorOrientation {
  case class TypeImpl(id: Int, direction: Byte) extends Type
  override def create(id: Int, direction: Byte) = TypeImpl(id, direction)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, direction: Byte) = create(id, direction)

  type Target = TypeImpl

}


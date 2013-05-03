




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ContentPart extends TypeDeserializer {
  val typeId = 350

  protected trait Type extends BaseType with Serializable {
    val typeId = ContentPart.typeId

    val id: String
    val state: Byte

    def serialize(buf: Buffer) {
      buf.writeString(id)
      buf.writeByte(state)
    }

  }

  protected def create(id: String, state: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readString()
    val state = buf.readByte()

    create(id, state)
  }

}

object ContentPart extends ContentPart {
  case class TypeImpl(id: String, state: Byte) extends Type
  override def create(id: String, state: Byte) = TypeImpl(id, state)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: String, state: Byte) = create(id, state)

  type Target = TypeImpl

}


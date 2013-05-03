




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait EntityMovementInformations extends TypeDeserializer {
  val typeId = 63

  protected trait Type extends BaseType with Serializable {
    val typeId = EntityMovementInformations.typeId

    val id: Int
    val steps: Seq[Byte]

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      buf.writeUShort(steps.length)
      for (entry <- steps) {
        buf.writeByte(entry)
      }
    }

  }

  protected def create(id: Int, steps: Seq[Byte]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val steps = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }

    create(id, steps)
  }

}

object EntityMovementInformations extends EntityMovementInformations {
  case class TypeImpl(id: Int, steps: Seq[Byte]) extends Type
  override def create(id: Int, steps: Seq[Byte]) = TypeImpl(id, steps)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, steps: Seq[Byte]) = create(id, steps)

  type Target = TypeImpl

}


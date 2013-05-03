




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterToRecolorInformation extends AbstractCharacterInformation {
  override val typeId = 212

  protected trait Type extends AbstractCharacterInformation.Type with Serializable {
    override val typeId = CharacterToRecolorInformation.typeId

    val colors: Seq[Int]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(colors.length)
      for (entry <- colors) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(id: Int, colors: Seq[Int]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val colors = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(id, colors)
  }

}

object CharacterToRecolorInformation extends CharacterToRecolorInformation {
  case class TypeImpl(id: Int, colors: Seq[Int]) extends Type
  override def create(id: Int, colors: Seq[Int]) = TypeImpl(id, colors)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, colors: Seq[Int]) = create(id, colors)

  type Target = TypeImpl

}


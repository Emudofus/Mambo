




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterToRelookInformation extends AbstractCharacterInformation {
  override val typeId = 399

  protected trait Type extends AbstractCharacterInformation.Type with Serializable {
    override val typeId = CharacterToRelookInformation.typeId

    val cosmeticId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(cosmeticId)
    }

  }

  protected def create(id: Int, cosmeticId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val cosmeticId = buf.readInt()

    create(id, cosmeticId)
  }

}

object CharacterToRelookInformation extends CharacterToRelookInformation {
  case class TypeImpl(id: Int, cosmeticId: Int) extends Type
  override def create(id: Int, cosmeticId: Int) = TypeImpl(id, cosmeticId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, cosmeticId: Int) = create(id, cosmeticId)

  type Target = TypeImpl

}


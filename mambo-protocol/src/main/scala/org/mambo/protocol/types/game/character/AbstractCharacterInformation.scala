




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AbstractCharacterInformation extends TypeDeserializer {
  val typeId = 400

  protected trait Type extends BaseType with Serializable {
    val typeId = AbstractCharacterInformation.typeId

    val id: Int

    def serialize(buf: Buffer) {
      buf.writeInt(id)
    }

  }

  protected def create(id: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()

    create(id)
  }

}

object AbstractCharacterInformation extends AbstractCharacterInformation {
  case class TypeImpl(id: Int) extends Type
  override def create(id: Int) = TypeImpl(id)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int) = create(id)

  type Target = TypeImpl

}


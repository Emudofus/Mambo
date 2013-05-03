




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterMinimalInformations extends AbstractCharacterInformation {
  override val typeId = 110

  protected trait Type extends AbstractCharacterInformation.Type with Serializable {
    override val typeId = CharacterMinimalInformations.typeId

    val level: UByte
    val name: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(level)
      buf.writeString(name)
    }

  }

  protected def create(id: Int, level: UByte, name: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()

    create(id, level, name)
  }

}

object CharacterMinimalInformations extends CharacterMinimalInformations {
  case class TypeImpl(id: Int, level: UByte, name: String) extends Type
  override def create(id: Int, level: UByte, name: String) = TypeImpl(id, level, name)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String) = create(id, level, name)

  type Target = TypeImpl

}


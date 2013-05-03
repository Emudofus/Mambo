




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterSpellModification extends TypeDeserializer {
  val typeId = 215

  protected trait Type extends BaseType with Serializable {
    val typeId = CharacterSpellModification.typeId

    val modificationType: Byte
    val spellId: Short
    val value: CharacterBaseCharacteristic.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeByte(modificationType)
      buf.writeShort(spellId)
      value.serialize(buf)
    }

  }

  protected def create(modificationType: Byte, spellId: Short, value: CharacterBaseCharacteristic.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val modificationType = buf.readByte()
    val spellId = buf.readShort()
    val value = CharacterBaseCharacteristic.deserialize(buf)

    create(modificationType, spellId, value)
  }

}

object CharacterSpellModification extends CharacterSpellModification {
  case class TypeImpl(modificationType: Byte, spellId: Short, value: CharacterBaseCharacteristic.TypeImpl) extends Type
  override def create(modificationType: Byte, spellId: Short, value: CharacterBaseCharacteristic.TypeImpl) = TypeImpl(modificationType, spellId, value)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(modificationType: Byte, spellId: Short, value: CharacterBaseCharacteristic.TypeImpl) = create(modificationType, spellId, value)

  type Target = TypeImpl

}


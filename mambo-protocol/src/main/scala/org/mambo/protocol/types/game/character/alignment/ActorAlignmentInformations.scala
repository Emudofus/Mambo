




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ActorAlignmentInformations extends TypeDeserializer {
  val typeId = 201

  protected trait Type extends BaseType with Serializable {
    val typeId = ActorAlignmentInformations.typeId

    val alignmentSide: Byte
    val alignmentValue: Byte
    val alignmentGrade: Byte
    val dishonor: UShort
    val characterPower: Int

    def serialize(buf: Buffer) {
      buf.writeByte(alignmentSide)
      buf.writeByte(alignmentValue)
      buf.writeByte(alignmentGrade)
      buf.writeUShort(dishonor)
      buf.writeInt(characterPower)
    }

  }

  protected def create(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val alignmentSide = buf.readByte()
    val alignmentValue = buf.readByte()
    val alignmentGrade = buf.readByte()
    val dishonor = buf.readUShort()
    val characterPower = buf.readInt()

    create(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower)
  }

}

object ActorAlignmentInformations extends ActorAlignmentInformations {
  case class TypeImpl(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int) extends Type
  override def create(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int) = TypeImpl(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int) = create(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower)

  type Target = TypeImpl

}


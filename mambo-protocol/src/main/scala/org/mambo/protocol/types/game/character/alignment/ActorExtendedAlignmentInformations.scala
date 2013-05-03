




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ActorExtendedAlignmentInformations extends ActorAlignmentInformations {
  override val typeId = 202

  protected trait Type extends ActorAlignmentInformations.Type with Serializable {
    override val typeId = ActorExtendedAlignmentInformations.typeId

    val honor: UShort
    val honorGradeFloor: UShort
    val honorNextGradeFloor: UShort
    val pvpEnabled: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(honor)
      buf.writeUShort(honorGradeFloor)
      buf.writeUShort(honorNextGradeFloor)
      buf.writeBoolean(pvpEnabled)
    }

  }

  protected def create(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int, honor: UShort, honorGradeFloor: UShort, honorNextGradeFloor: UShort, pvpEnabled: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val alignmentSide = buf.readByte()
    val alignmentValue = buf.readByte()
    val alignmentGrade = buf.readByte()
    val dishonor = buf.readUShort()
    val characterPower = buf.readInt()
    val honor = buf.readUShort()
    val honorGradeFloor = buf.readUShort()
    val honorNextGradeFloor = buf.readUShort()
    val pvpEnabled = buf.readBoolean()

    create(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower, honor, honorGradeFloor, honorNextGradeFloor, pvpEnabled)
  }

}

object ActorExtendedAlignmentInformations extends ActorExtendedAlignmentInformations {
  case class TypeImpl(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int, honor: UShort, honorGradeFloor: UShort, honorNextGradeFloor: UShort, pvpEnabled: Boolean) extends Type
  override def create(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int, honor: UShort, honorGradeFloor: UShort, honorNextGradeFloor: UShort, pvpEnabled: Boolean) = TypeImpl(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower, honor, honorGradeFloor, honorNextGradeFloor, pvpEnabled)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(alignmentSide: Byte, alignmentValue: Byte, alignmentGrade: Byte, dishonor: UShort, characterPower: Int, honor: UShort, honorGradeFloor: UShort, honorNextGradeFloor: UShort, pvpEnabled: Boolean) = create(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower, honor, honorGradeFloor, honorNextGradeFloor, pvpEnabled)

  type Target = TypeImpl

}


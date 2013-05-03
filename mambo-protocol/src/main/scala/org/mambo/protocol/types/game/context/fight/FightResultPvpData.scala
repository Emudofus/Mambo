




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultPvpData extends FightResultAdditionalData {
  override val typeId = 190

  protected trait Type extends FightResultAdditionalData.Type with Serializable {
    override val typeId = FightResultPvpData.typeId

    val grade: UByte
    val minHonorForGrade: UShort
    val maxHonorForGrade: UShort
    val honor: UShort
    val honorDelta: Short
    val dishonor: UShort
    val dishonorDelta: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(grade)
      buf.writeUShort(minHonorForGrade)
      buf.writeUShort(maxHonorForGrade)
      buf.writeUShort(honor)
      buf.writeShort(honorDelta)
      buf.writeUShort(dishonor)
      buf.writeShort(dishonorDelta)
    }

  }

  protected def create(grade: UByte, minHonorForGrade: UShort, maxHonorForGrade: UShort, honor: UShort, honorDelta: Short, dishonor: UShort, dishonorDelta: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val grade = buf.readUByte()
    val minHonorForGrade = buf.readUShort()
    val maxHonorForGrade = buf.readUShort()
    val honor = buf.readUShort()
    val honorDelta = buf.readShort()
    val dishonor = buf.readUShort()
    val dishonorDelta = buf.readShort()

    create(grade, minHonorForGrade, maxHonorForGrade, honor, honorDelta, dishonor, dishonorDelta)
  }

}

object FightResultPvpData extends FightResultPvpData {
  case class TypeImpl(grade: UByte, minHonorForGrade: UShort, maxHonorForGrade: UShort, honor: UShort, honorDelta: Short, dishonor: UShort, dishonorDelta: Short) extends Type
  override def create(grade: UByte, minHonorForGrade: UShort, maxHonorForGrade: UShort, honor: UShort, honorDelta: Short, dishonor: UShort, dishonorDelta: Short) = TypeImpl(grade, minHonorForGrade, maxHonorForGrade, honor, honorDelta, dishonor, dishonorDelta)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(grade: UByte, minHonorForGrade: UShort, maxHonorForGrade: UShort, honor: UShort, honorDelta: Short, dishonor: UShort, dishonorDelta: Short) = create(grade, minHonorForGrade, maxHonorForGrade, honor, honorDelta, dishonor, dishonorDelta)

  type Target = TypeImpl

}


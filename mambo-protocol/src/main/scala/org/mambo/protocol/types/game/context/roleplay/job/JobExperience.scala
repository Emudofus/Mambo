




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait JobExperience extends TypeDeserializer {
  val typeId = 98

  protected trait Type extends BaseType with Serializable {
    val typeId = JobExperience.typeId

    val jobId: Byte
    val jobLevel: Byte
    val jobXP: Double
    val jobXpLevelFloor: Double
    val jobXpNextLevelFloor: Double

    def serialize(buf: Buffer) {
      buf.writeByte(jobId)
      buf.writeByte(jobLevel)
      buf.writeDouble(jobXP)
      buf.writeDouble(jobXpLevelFloor)
      buf.writeDouble(jobXpNextLevelFloor)
    }

  }

  protected def create(jobId: Byte, jobLevel: Byte, jobXP: Double, jobXpLevelFloor: Double, jobXpNextLevelFloor: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobId = buf.readByte()
    val jobLevel = buf.readByte()
    val jobXP = buf.readDouble()
    val jobXpLevelFloor = buf.readDouble()
    val jobXpNextLevelFloor = buf.readDouble()

    create(jobId, jobLevel, jobXP, jobXpLevelFloor, jobXpNextLevelFloor)
  }

}

object JobExperience extends JobExperience {
  case class TypeImpl(jobId: Byte, jobLevel: Byte, jobXP: Double, jobXpLevelFloor: Double, jobXpNextLevelFloor: Double) extends Type
  override def create(jobId: Byte, jobLevel: Byte, jobXP: Double, jobXpLevelFloor: Double, jobXpNextLevelFloor: Double) = TypeImpl(jobId, jobLevel, jobXP, jobXpLevelFloor, jobXpNextLevelFloor)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(jobId: Byte, jobLevel: Byte, jobXP: Double, jobXpLevelFloor: Double, jobXpNextLevelFloor: Double) = create(jobId, jobLevel, jobXP, jobXpLevelFloor, jobXpNextLevelFloor)

  type Target = TypeImpl

}


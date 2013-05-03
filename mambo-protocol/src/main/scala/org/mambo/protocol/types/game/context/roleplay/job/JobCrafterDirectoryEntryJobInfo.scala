




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait JobCrafterDirectoryEntryJobInfo extends TypeDeserializer {
  val typeId = 195

  protected trait Type extends BaseType with Serializable {
    val typeId = JobCrafterDirectoryEntryJobInfo.typeId

    val jobId: Byte
    val jobLevel: Byte
    val userDefinedParams: Byte
    val minSlots: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(jobId)
      buf.writeByte(jobLevel)
      buf.writeByte(userDefinedParams)
      buf.writeByte(minSlots)
    }

  }

  protected def create(jobId: Byte, jobLevel: Byte, userDefinedParams: Byte, minSlots: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobId = buf.readByte()
    val jobLevel = buf.readByte()
    val userDefinedParams = buf.readByte()
    val minSlots = buf.readByte()

    create(jobId, jobLevel, userDefinedParams, minSlots)
  }

}

object JobCrafterDirectoryEntryJobInfo extends JobCrafterDirectoryEntryJobInfo {
  case class TypeImpl(jobId: Byte, jobLevel: Byte, userDefinedParams: Byte, minSlots: Byte) extends Type
  override def create(jobId: Byte, jobLevel: Byte, userDefinedParams: Byte, minSlots: Byte) = TypeImpl(jobId, jobLevel, userDefinedParams, minSlots)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(jobId: Byte, jobLevel: Byte, userDefinedParams: Byte, minSlots: Byte) = create(jobId, jobLevel, userDefinedParams, minSlots)

  type Target = TypeImpl

}


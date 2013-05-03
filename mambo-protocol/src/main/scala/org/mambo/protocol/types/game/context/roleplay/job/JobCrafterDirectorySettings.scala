




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait JobCrafterDirectorySettings extends TypeDeserializer {
  val typeId = 97

  protected trait Type extends BaseType with Serializable {
    val typeId = JobCrafterDirectorySettings.typeId

    val jobId: Byte
    val minSlot: Byte
    val userDefinedParams: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(jobId)
      buf.writeByte(minSlot)
      buf.writeByte(userDefinedParams)
    }

  }

  protected def create(jobId: Byte, minSlot: Byte, userDefinedParams: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobId = buf.readByte()
    val minSlot = buf.readByte()
    val userDefinedParams = buf.readByte()

    create(jobId, minSlot, userDefinedParams)
  }

}

object JobCrafterDirectorySettings extends JobCrafterDirectorySettings {
  case class TypeImpl(jobId: Byte, minSlot: Byte, userDefinedParams: Byte) extends Type
  override def create(jobId: Byte, minSlot: Byte, userDefinedParams: Byte) = TypeImpl(jobId, minSlot, userDefinedParams)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(jobId: Byte, minSlot: Byte, userDefinedParams: Byte) = create(jobId, minSlot, userDefinedParams)

  type Target = TypeImpl

}


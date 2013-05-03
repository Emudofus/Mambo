




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait JobDescription extends TypeDeserializer {
  val typeId = 101

  protected trait Type extends BaseType with Serializable {
    val typeId = JobDescription.typeId

    val jobId: Byte
    val skills: Seq[SkillActionDescription.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeByte(jobId)
      buf.writeUShort(skills.length)
      for (entry <- skills) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(jobId: Byte, skills: Seq[SkillActionDescription.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobId = buf.readByte()
    val skills = {
      val builder = collection.immutable.Seq.newBuilder[SkillActionDescription.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[SkillActionDescription.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(jobId, skills)
  }

}

object JobDescription extends JobDescription {
  case class TypeImpl(jobId: Byte, skills: Seq[SkillActionDescription.TypeImpl]) extends Type
  override def create(jobId: Byte, skills: Seq[SkillActionDescription.TypeImpl]) = TypeImpl(jobId, skills)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(jobId: Byte, skills: Seq[SkillActionDescription.TypeImpl]) = create(jobId, skills)

  type Target = TypeImpl

}


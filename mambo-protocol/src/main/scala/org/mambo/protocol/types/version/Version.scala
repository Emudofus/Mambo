




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait Version extends TypeDeserializer {
  val typeId = 11

  protected trait Type extends BaseType with Serializable {
    val typeId = Version.typeId

    val major: Byte
    val minor: Byte
    val release: Byte
    val revision: Int
    val patch: Byte
    val buildType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(major)
      buf.writeByte(minor)
      buf.writeByte(release)
      buf.writeInt(revision)
      buf.writeByte(patch)
      buf.writeByte(buildType)
    }

  }

  protected def create(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val major = buf.readByte()
    val minor = buf.readByte()
    val release = buf.readByte()
    val revision = buf.readInt()
    val patch = buf.readByte()
    val buildType = buf.readByte()

    create(major, minor, release, revision, patch, buildType)
  }

}

object Version extends Version {
  case class TypeImpl(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte) extends Type
  override def create(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte) = TypeImpl(major, minor, release, revision, patch, buildType)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte) = create(major, minor, release, revision, patch, buildType)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait VersionExtended extends Version {
  override val typeId = 393

  protected trait Type extends Version.Type with Serializable {
    override val typeId = VersionExtended.typeId

    val install: Byte
    val technology: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(install)
      buf.writeByte(technology)
    }

  }

  protected def create(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte, install: Byte, technology: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val major = buf.readByte()
    val minor = buf.readByte()
    val release = buf.readByte()
    val revision = buf.readInt()
    val patch = buf.readByte()
    val buildType = buf.readByte()
    val install = buf.readByte()
    val technology = buf.readByte()

    create(major, minor, release, revision, patch, buildType, install, technology)
  }

}

object VersionExtended extends VersionExtended {
  case class TypeImpl(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte, install: Byte, technology: Byte) extends Type
  override def create(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte, install: Byte, technology: Byte) = TypeImpl(major, minor, release, revision, patch, buildType, install, technology)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(major: Byte, minor: Byte, release: Byte, revision: Int, patch: Byte, buildType: Byte, install: Byte, technology: Byte) = create(major, minor, release, revision, patch, buildType, install, technology)

  type Target = TypeImpl

}


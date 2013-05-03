




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait JobCrafterDirectoryListEntry extends TypeDeserializer {
  val typeId = 196

  protected trait Type extends BaseType with Serializable {
    val typeId = JobCrafterDirectoryListEntry.typeId

    val playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl
    val jobInfo: JobCrafterDirectoryEntryJobInfo.TypeImpl

    def serialize(buf: Buffer) {
      playerInfo.serialize(buf)
      jobInfo.serialize(buf)
    }

  }

  protected def create(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfo: JobCrafterDirectoryEntryJobInfo.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerInfo = JobCrafterDirectoryEntryPlayerInfo.deserialize(buf)
    val jobInfo = JobCrafterDirectoryEntryJobInfo.deserialize(buf)

    create(playerInfo, jobInfo)
  }

}

object JobCrafterDirectoryListEntry extends JobCrafterDirectoryListEntry {
  case class TypeImpl(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfo: JobCrafterDirectoryEntryJobInfo.TypeImpl) extends Type
  override def create(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfo: JobCrafterDirectoryEntryJobInfo.TypeImpl) = TypeImpl(playerInfo, jobInfo)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfo: JobCrafterDirectoryEntryJobInfo.TypeImpl) = create(playerInfo, jobInfo)

  type Target = TypeImpl

}


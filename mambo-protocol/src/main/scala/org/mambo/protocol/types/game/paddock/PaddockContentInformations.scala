




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockContentInformations extends PaddockInformations {
  override val typeId = 183

  protected trait Type extends PaddockInformations.Type with Serializable {
    override val typeId = PaddockContentInformations.typeId

    val paddockId: Int
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short
    val abandonned: Boolean
    val mountsInformations: Seq[MountInformationsForPaddock.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(paddockId)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
      buf.writeBoolean(abandonned)
      buf.writeUShort(mountsInformations.length)
      for (entry <- mountsInformations) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(maxOutdoorMount: Short, maxItems: Short, paddockId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, abandonned: Boolean, mountsInformations: Seq[MountInformationsForPaddock.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val maxOutdoorMount = buf.readShort()
    val maxItems = buf.readShort()
    val paddockId = buf.readInt()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()
    val abandonned = buf.readBoolean()
    val mountsInformations = {
      val builder = collection.immutable.Seq.newBuilder[MountInformationsForPaddock.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MountInformationsForPaddock.deserialize(buf)
      }
      builder.result()
    }

    create(maxOutdoorMount, maxItems, paddockId, worldX, worldY, mapId, subAreaId, abandonned, mountsInformations)
  }

}

object PaddockContentInformations extends PaddockContentInformations {
  case class TypeImpl(maxOutdoorMount: Short, maxItems: Short, paddockId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, abandonned: Boolean, mountsInformations: Seq[MountInformationsForPaddock.TypeImpl]) extends Type
  override def create(maxOutdoorMount: Short, maxItems: Short, paddockId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, abandonned: Boolean, mountsInformations: Seq[MountInformationsForPaddock.TypeImpl]) = TypeImpl(maxOutdoorMount, maxItems, paddockId, worldX, worldY, mapId, subAreaId, abandonned, mountsInformations)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(maxOutdoorMount: Short, maxItems: Short, paddockId: Int, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, abandonned: Boolean, mountsInformations: Seq[MountInformationsForPaddock.TypeImpl]) = create(maxOutdoorMount, maxItems, paddockId, worldX, worldY, mapId, subAreaId, abandonned, mountsInformations)

  type Target = TypeImpl

}


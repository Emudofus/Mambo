




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait Preset extends TypeDeserializer {
  val typeId = 355

  protected trait Type extends BaseType with Serializable {
    val typeId = Preset.typeId

    val presetId: Byte
    val symbolId: Byte
    val mount: Boolean
    val objects: Seq[PresetItem.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeByte(presetId)
      buf.writeByte(symbolId)
      buf.writeBoolean(mount)
      buf.writeUShort(objects.length)
      for (entry <- objects) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(presetId: Byte, symbolId: Byte, mount: Boolean, objects: Seq[PresetItem.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val presetId = buf.readByte()
    val symbolId = buf.readByte()
    val mount = buf.readBoolean()
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[PresetItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PresetItem.deserialize(buf)
      }
      builder.result()
    }

    create(presetId, symbolId, mount, objects)
  }

}

object Preset extends Preset {
  case class TypeImpl(presetId: Byte, symbolId: Byte, mount: Boolean, objects: Seq[PresetItem.TypeImpl]) extends Type
  override def create(presetId: Byte, symbolId: Byte, mount: Boolean, objects: Seq[PresetItem.TypeImpl]) = TypeImpl(presetId, symbolId, mount, objects)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(presetId: Byte, symbolId: Byte, mount: Boolean, objects: Seq[PresetItem.TypeImpl]) = create(presetId, symbolId, mount, objects)

  type Target = TypeImpl

}


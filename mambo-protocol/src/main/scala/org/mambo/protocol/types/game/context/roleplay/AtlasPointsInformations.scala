




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AtlasPointsInformations extends TypeDeserializer {
  val typeId = 175

  protected trait Type extends BaseType with Serializable {
    val typeId = AtlasPointsInformations.typeId

    val theType: Byte
    val coords: Seq[MapCoordinatesExtended.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeByte(theType)
      buf.writeUShort(coords.length)
      for (entry <- coords) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(theType: Byte, coords: Seq[MapCoordinatesExtended.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = buf.readByte()
    val coords = {
      val builder = collection.immutable.Seq.newBuilder[MapCoordinatesExtended.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MapCoordinatesExtended.deserialize(buf)
      }
      builder.result()
    }

    create(theType, coords)
  }

}

object AtlasPointsInformations extends AtlasPointsInformations {
  case class TypeImpl(theType: Byte, coords: Seq[MapCoordinatesExtended.TypeImpl]) extends Type
  override def create(theType: Byte, coords: Seq[MapCoordinatesExtended.TypeImpl]) = TypeImpl(theType, coords)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(theType: Byte, coords: Seq[MapCoordinatesExtended.TypeImpl]) = create(theType, coords)

  type Target = TypeImpl

}


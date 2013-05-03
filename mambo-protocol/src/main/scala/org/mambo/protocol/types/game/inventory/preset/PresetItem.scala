




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PresetItem extends TypeDeserializer {
  val typeId = 354

  protected trait Type extends BaseType with Serializable {
    val typeId = PresetItem.typeId

    val position: UByte
    val objGid: Int
    val objUid: Int

    def serialize(buf: Buffer) {
      buf.writeUByte(position)
      buf.writeInt(objGid)
      buf.writeInt(objUid)
    }

  }

  protected def create(position: UByte, objGid: Int, objUid: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val position = buf.readUByte()
    val objGid = buf.readInt()
    val objUid = buf.readInt()

    create(position, objGid, objUid)
  }

}

object PresetItem extends PresetItem {
  case class TypeImpl(position: UByte, objGid: Int, objUid: Int) extends Type
  override def create(position: UByte, objGid: Int, objUid: Int) = TypeImpl(position, objGid, objUid)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(position: UByte, objGid: Int, objUid: Int) = create(position, objGid, objUid)

  type Target = TypeImpl

}


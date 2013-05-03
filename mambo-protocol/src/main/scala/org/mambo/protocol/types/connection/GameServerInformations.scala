




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameServerInformations extends TypeDeserializer {
  val typeId = 25

  protected trait Type extends BaseType with Serializable {
    val typeId = GameServerInformations.typeId

    val id: UShort
    val status: Byte
    val completion: Byte
    val isSelectable: Boolean
    val charactersCount: Byte
    val date: Double

    def serialize(buf: Buffer) {
      buf.writeUShort(id)
      buf.writeByte(status)
      buf.writeByte(completion)
      buf.writeBoolean(isSelectable)
      buf.writeByte(charactersCount)
      buf.writeDouble(date)
    }

  }

  protected def create(id: UShort, status: Byte, completion: Byte, isSelectable: Boolean, charactersCount: Byte, date: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readUShort()
    val status = buf.readByte()
    val completion = buf.readByte()
    val isSelectable = buf.readBoolean()
    val charactersCount = buf.readByte()
    val date = buf.readDouble()

    create(id, status, completion, isSelectable, charactersCount, date)
  }

}

object GameServerInformations extends GameServerInformations {
  case class TypeImpl(id: UShort, status: Byte, completion: Byte, isSelectable: Boolean, charactersCount: Byte, date: Double) extends Type
  override def create(id: UShort, status: Byte, completion: Byte, isSelectable: Boolean, charactersCount: Byte, date: Double) = TypeImpl(id, status, completion, isSelectable, charactersCount, date)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: UShort, status: Byte, completion: Byte, isSelectable: Boolean, charactersCount: Byte, date: Double) = create(id, status, completion, isSelectable, charactersCount, date)

  type Target = TypeImpl

}


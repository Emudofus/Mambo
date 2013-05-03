




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockInformationsForSell extends TypeDeserializer {
  val typeId = 222

  protected trait Type extends BaseType with Serializable {
    val typeId = PaddockInformationsForSell.typeId

    val guildOwner: String
    val worldX: Short
    val worldY: Short
    val subAreaId: Short
    val nbMount: Byte
    val nbObject: Byte
    val price: Int

    def serialize(buf: Buffer) {
      buf.writeString(guildOwner)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeShort(subAreaId)
      buf.writeByte(nbMount)
      buf.writeByte(nbObject)
      buf.writeInt(price)
    }

  }

  protected def create(guildOwner: String, worldX: Short, worldY: Short, subAreaId: Short, nbMount: Byte, nbObject: Byte, price: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildOwner = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val subAreaId = buf.readShort()
    val nbMount = buf.readByte()
    val nbObject = buf.readByte()
    val price = buf.readInt()

    create(guildOwner, worldX, worldY, subAreaId, nbMount, nbObject, price)
  }

}

object PaddockInformationsForSell extends PaddockInformationsForSell {
  case class TypeImpl(guildOwner: String, worldX: Short, worldY: Short, subAreaId: Short, nbMount: Byte, nbObject: Byte, price: Int) extends Type
  override def create(guildOwner: String, worldX: Short, worldY: Short, subAreaId: Short, nbMount: Byte, nbObject: Byte, price: Int) = TypeImpl(guildOwner, worldX, worldY, subAreaId, nbMount, nbObject, price)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(guildOwner: String, worldX: Short, worldY: Short, subAreaId: Short, nbMount: Byte, nbObject: Byte, price: Int) = create(guildOwner, worldX, worldY, subAreaId, nbMount, nbObject, price)

  type Target = TypeImpl

}


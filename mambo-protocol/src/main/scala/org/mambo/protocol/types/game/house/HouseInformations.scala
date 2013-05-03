




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HouseInformations extends TypeDeserializer {
  val typeId = 111

  protected trait Type extends BaseType with Serializable {
    val typeId = HouseInformations.typeId

    val isOnSale: Boolean
    val isSaleLocked: Boolean
    val houseId: Int
    val doorsOnMap: Seq[Int]
    val ownerName: String
    val modelId: Short

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, isOnSale)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, isSaleLocked)
      buf.writeUByte(flag1.toShort)
      buf.writeInt(houseId)
      buf.writeUShort(doorsOnMap.length)
      for (entry <- doorsOnMap) {
        buf.writeInt(entry)
      }
      buf.writeString(ownerName)
      buf.writeShort(modelId)
    }

  }

  protected def create(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val isOnSale = BooleanByteWrapper.getFlag(flag1, 0)
    val isSaleLocked = BooleanByteWrapper.getFlag(flag1, 1)
    val houseId = buf.readInt()
    val doorsOnMap = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val ownerName = buf.readString()
    val modelId = buf.readShort()

    create(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId)
  }

}

object HouseInformations extends HouseInformations {
  case class TypeImpl(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short) extends Type
  override def create(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short) = TypeImpl(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short) = create(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HouseInformationsExtended extends HouseInformations {
  override val typeId = 112

  protected trait Type extends HouseInformations.Type with Serializable {
    override val typeId = HouseInformationsExtended.typeId

    val guildInfo: GuildInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      guildInfo.serialize(buf)
    }

  }

  protected def create(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short, guildInfo: GuildInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
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
    val guildInfo = GuildInformations.deserialize(buf)

    create(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId, guildInfo)
  }

}

object HouseInformationsExtended extends HouseInformationsExtended {
  case class TypeImpl(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short, guildInfo: GuildInformations.TypeImpl) extends Type
  override def create(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short, guildInfo: GuildInformations.TypeImpl) = TypeImpl(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId, guildInfo)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(isOnSale: Boolean, isSaleLocked: Boolean, houseId: Int, doorsOnMap: Seq[Int], ownerName: String, modelId: Short, guildInfo: GuildInformations.TypeImpl) = create(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId, guildInfo)

  type Target = TypeImpl

}























// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FriendSpouseOnlineInformations extends FriendSpouseInformations {
  override val typeId = 93

  protected trait Type extends FriendSpouseInformations.Type with Serializable {
    override val typeId = FriendSpouseOnlineInformations.typeId

    val inFight: Boolean
    val followSpouse: Boolean
    val pvpEnabled: Boolean
    val mapId: Int
    val subAreaId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, inFight)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, followSpouse)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, pvpEnabled)
      buf.writeUByte(flag1.toShort)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte, inFight: Boolean, followSpouse: Boolean, pvpEnabled: Boolean, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val spouseAccountId = buf.readInt()
    val spouseId = buf.readInt()
    val spouseName = buf.readString()
    val spouseLevel = buf.readUByte()
    val breed = buf.readByte()
    val sex = buf.readByte()
    val spouseEntityLook = EntityLook.deserialize(buf)
    val guildInfo = BasicGuildInformations.deserialize(buf)
    val alignmentSide = buf.readByte()
    val flag1 = buf.readUByte()
    val inFight = BooleanByteWrapper.getFlag(flag1, 0)
    val followSpouse = BooleanByteWrapper.getFlag(flag1, 1)
    val pvpEnabled = BooleanByteWrapper.getFlag(flag1, 2)
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide, inFight, followSpouse, pvpEnabled, mapId, subAreaId)
  }

}

object FriendSpouseOnlineInformations extends FriendSpouseOnlineInformations {
  case class TypeImpl(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte, inFight: Boolean, followSpouse: Boolean, pvpEnabled: Boolean, mapId: Int, subAreaId: Short) extends Type
  override def create(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte, inFight: Boolean, followSpouse: Boolean, pvpEnabled: Boolean, mapId: Int, subAreaId: Short) = TypeImpl(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide, inFight, followSpouse, pvpEnabled, mapId, subAreaId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte, inFight: Boolean, followSpouse: Boolean, pvpEnabled: Boolean, mapId: Int, subAreaId: Short) = create(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide, inFight, followSpouse, pvpEnabled, mapId, subAreaId)

  type Target = TypeImpl

}


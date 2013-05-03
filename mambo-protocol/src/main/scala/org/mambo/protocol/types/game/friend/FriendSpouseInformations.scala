




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FriendSpouseInformations extends TypeDeserializer {
  val typeId = 77

  protected trait Type extends BaseType with Serializable {
    val typeId = FriendSpouseInformations.typeId

    val spouseAccountId: Int
    val spouseId: Int
    val spouseName: String
    val spouseLevel: UByte
    val breed: Byte
    val sex: Byte
    val spouseEntityLook: EntityLook.TypeImpl
    val guildInfo: BasicGuildInformations.TypeImpl
    val alignmentSide: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(spouseAccountId)
      buf.writeInt(spouseId)
      buf.writeString(spouseName)
      buf.writeUByte(spouseLevel)
      buf.writeByte(breed)
      buf.writeByte(sex)
      spouseEntityLook.serialize(buf)
      guildInfo.serialize(buf)
      buf.writeByte(alignmentSide)
    }

  }

  protected def create(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spouseAccountId = buf.readInt()
    val spouseId = buf.readInt()
    val spouseName = buf.readString()
    val spouseLevel = buf.readUByte()
    val breed = buf.readByte()
    val sex = buf.readByte()
    val spouseEntityLook = EntityLook.deserialize(buf)
    val guildInfo = BasicGuildInformations.deserialize(buf)
    val alignmentSide = buf.readByte()

    create(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide)
  }

}

object FriendSpouseInformations extends FriendSpouseInformations {
  case class TypeImpl(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte) extends Type
  override def create(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte) = TypeImpl(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(spouseAccountId: Int, spouseId: Int, spouseName: String, spouseLevel: UByte, breed: Byte, sex: Byte, spouseEntityLook: EntityLook.TypeImpl, guildInfo: BasicGuildInformations.TypeImpl, alignmentSide: Byte) = create(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide)

  type Target = TypeImpl

}


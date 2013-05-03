




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GuildMember extends CharacterMinimalInformations {
  override val typeId = 88

  protected trait Type extends CharacterMinimalInformations.Type with Serializable {
    override val typeId = GuildMember.typeId

    val breed: Byte
    val sex: Boolean
    val rank: Short
    val givenExperience: Double
    val experienceGivenPercent: Byte
    val rights: UInt
    val connected: Byte
    val alignmentSide: Byte
    val hoursSinceLastConnection: UShort
    val moodSmileyId: Byte
    val accountId: Int
    val achievementPoints: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(breed)
      buf.writeBoolean(sex)
      buf.writeShort(rank)
      buf.writeDouble(givenExperience)
      buf.writeByte(experienceGivenPercent)
      buf.writeUInt(rights)
      buf.writeByte(connected)
      buf.writeByte(alignmentSide)
      buf.writeUShort(hoursSinceLastConnection)
      buf.writeByte(moodSmileyId)
      buf.writeInt(accountId)
      buf.writeInt(achievementPoints)
    }

  }

  protected def create(id: Int, level: UByte, name: String, breed: Byte, sex: Boolean, rank: Short, givenExperience: Double, experienceGivenPercent: Byte, rights: UInt, connected: Byte, alignmentSide: Byte, hoursSinceLastConnection: UShort, moodSmileyId: Byte, accountId: Int, achievementPoints: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val level = buf.readUByte()
    val name = buf.readString()
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val rank = buf.readShort()
    val givenExperience = buf.readDouble()
    val experienceGivenPercent = buf.readByte()
    val rights = buf.readUInt()
    val connected = buf.readByte()
    val alignmentSide = buf.readByte()
    val hoursSinceLastConnection = buf.readUShort()
    val moodSmileyId = buf.readByte()
    val accountId = buf.readInt()
    val achievementPoints = buf.readInt()

    create(id, level, name, breed, sex, rank, givenExperience, experienceGivenPercent, rights, connected, alignmentSide, hoursSinceLastConnection, moodSmileyId, accountId, achievementPoints)
  }

}

object GuildMember extends GuildMember {
  case class TypeImpl(id: Int, level: UByte, name: String, breed: Byte, sex: Boolean, rank: Short, givenExperience: Double, experienceGivenPercent: Byte, rights: UInt, connected: Byte, alignmentSide: Byte, hoursSinceLastConnection: UShort, moodSmileyId: Byte, accountId: Int, achievementPoints: Int) extends Type
  override def create(id: Int, level: UByte, name: String, breed: Byte, sex: Boolean, rank: Short, givenExperience: Double, experienceGivenPercent: Byte, rights: UInt, connected: Byte, alignmentSide: Byte, hoursSinceLastConnection: UShort, moodSmileyId: Byte, accountId: Int, achievementPoints: Int) = TypeImpl(id, level, name, breed, sex, rank, givenExperience, experienceGivenPercent, rights, connected, alignmentSide, hoursSinceLastConnection, moodSmileyId, accountId, achievementPoints)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, level: UByte, name: String, breed: Byte, sex: Boolean, rank: Short, givenExperience: Double, experienceGivenPercent: Byte, rights: UInt, connected: Byte, alignmentSide: Byte, hoursSinceLastConnection: UShort, moodSmileyId: Byte, accountId: Int, achievementPoints: Int) = create(id, level, name, breed, sex, rank, givenExperience, experienceGivenPercent, rights, connected, alignmentSide, hoursSinceLastConnection, moodSmileyId, accountId, achievementPoints)

  type Target = TypeImpl

}


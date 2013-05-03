




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FriendOnlineInformations extends FriendInformations {
  override val typeId = 92

  protected trait Type extends FriendInformations.Type with Serializable {
    override val typeId = FriendOnlineInformations.typeId

    val playerName: String
    val level: Short
    val alignmentSide: Byte
    val breed: Byte
    val sex: Boolean
    val guildInfo: BasicGuildInformations.TypeImpl
    val moodSmileyId: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(playerName)
      buf.writeShort(level)
      buf.writeByte(alignmentSide)
      buf.writeByte(breed)
      buf.writeBoolean(sex)
      guildInfo.serialize(buf)
      buf.writeByte(moodSmileyId)
    }

  }

  protected def create(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int, playerName: String, level: Short, alignmentSide: Byte, breed: Byte, sex: Boolean, guildInfo: BasicGuildInformations.TypeImpl, moodSmileyId: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val accountId = buf.readInt()
    val accountName = buf.readString()
    val playerState = buf.readByte()
    val lastConnection = buf.readInt()
    val achievementPoints = buf.readInt()
    val playerName = buf.readString()
    val level = buf.readShort()
    val alignmentSide = buf.readByte()
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val guildInfo = BasicGuildInformations.deserialize(buf)
    val moodSmileyId = buf.readByte()

    create(accountId, accountName, playerState, lastConnection, achievementPoints, playerName, level, alignmentSide, breed, sex, guildInfo, moodSmileyId)
  }

}

object FriendOnlineInformations extends FriendOnlineInformations {
  case class TypeImpl(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int, playerName: String, level: Short, alignmentSide: Byte, breed: Byte, sex: Boolean, guildInfo: BasicGuildInformations.TypeImpl, moodSmileyId: Byte) extends Type
  override def create(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int, playerName: String, level: Short, alignmentSide: Byte, breed: Byte, sex: Boolean, guildInfo: BasicGuildInformations.TypeImpl, moodSmileyId: Byte) = TypeImpl(accountId, accountName, playerState, lastConnection, achievementPoints, playerName, level, alignmentSide, breed, sex, guildInfo, moodSmileyId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int, playerName: String, level: Short, alignmentSide: Byte, breed: Byte, sex: Boolean, guildInfo: BasicGuildInformations.TypeImpl, moodSmileyId: Byte) = create(accountId, accountName, playerState, lastConnection, achievementPoints, playerName, level, alignmentSide, breed, sex, guildInfo, moodSmileyId)

  type Target = TypeImpl

}


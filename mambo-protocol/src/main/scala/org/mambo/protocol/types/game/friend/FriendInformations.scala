




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FriendInformations extends AbstractContactInformations {
  override val typeId = 78

  protected trait Type extends AbstractContactInformations.Type with Serializable {
    override val typeId = FriendInformations.typeId

    val playerState: Byte
    val lastConnection: Int
    val achievementPoints: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(playerState)
      buf.writeInt(lastConnection)
      buf.writeInt(achievementPoints)
    }

  }

  protected def create(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val accountId = buf.readInt()
    val accountName = buf.readString()
    val playerState = buf.readByte()
    val lastConnection = buf.readInt()
    val achievementPoints = buf.readInt()

    create(accountId, accountName, playerState, lastConnection, achievementPoints)
  }

}

object FriendInformations extends FriendInformations {
  case class TypeImpl(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int) extends Type
  override def create(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int) = TypeImpl(accountId, accountName, playerState, lastConnection, achievementPoints)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(accountId: Int, accountName: String, playerState: Byte, lastConnection: Int, achievementPoints: Int) = create(accountId, accountName, playerState, lastConnection, achievementPoints)

  type Target = TypeImpl

}


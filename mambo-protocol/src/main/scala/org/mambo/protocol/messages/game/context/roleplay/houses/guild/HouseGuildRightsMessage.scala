




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseGuildRightsMessage extends MessageDeserializer {
  val messageId = 5703

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseGuildRightsMessage.messageId

    val houseId: Short
    val guildInfo: GuildInformations.TypeImpl
    val rights: UInt

    def serialize(buf: Buffer) {
      buf.writeShort(houseId)
      guildInfo.serialize(buf)
      buf.writeUInt(rights)
    }

  }

  protected def create(houseId: Short, guildInfo: GuildInformations.TypeImpl, rights: UInt): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readShort()
    val guildInfo = GuildInformations.deserialize(buf)
    val rights = buf.readUInt()

    create(houseId, guildInfo, rights)
  }

}

object HouseGuildRightsMessage extends HouseGuildRightsMessage {
  case class MessageImpl(houseId: Short, guildInfo: GuildInformations.TypeImpl, rights: UInt) extends Message
  type Target = MessageImpl

  override def create(houseId: Short, guildInfo: GuildInformations.TypeImpl, rights: UInt) = MessageImpl(houseId, guildInfo, rights)

  def apply(houseId: Short, guildInfo: GuildInformations.TypeImpl, rights: UInt) = create(houseId, guildInfo, rights)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


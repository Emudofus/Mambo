




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildFightPlayersHelpersJoinMessage extends MessageDeserializer {
  val messageId = 5720

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildFightPlayersHelpersJoinMessage.messageId

    val fightId: Double
    val playerInfo: CharacterMinimalPlusLookInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      playerInfo.serialize(buf)
    }

  }

  protected def create(fightId: Double, playerInfo: CharacterMinimalPlusLookInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val playerInfo = CharacterMinimalPlusLookInformations.deserialize(buf)

    create(fightId, playerInfo)
  }

}

object GuildFightPlayersHelpersJoinMessage extends GuildFightPlayersHelpersJoinMessage {
  case class MessageImpl(fightId: Double, playerInfo: CharacterMinimalPlusLookInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, playerInfo: CharacterMinimalPlusLookInformations.TypeImpl) = MessageImpl(fightId, playerInfo)

  def apply(fightId: Double, playerInfo: CharacterMinimalPlusLookInformations.TypeImpl) = create(fightId, playerInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


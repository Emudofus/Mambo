




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildFightPlayersEnemiesListMessage extends MessageDeserializer {
  val messageId = 5928

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildFightPlayersEnemiesListMessage.messageId

    val fightId: Double
    val playerInfo: Seq[CharacterMinimalPlusLookInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeUShort(playerInfo.length)
      for (entry <- playerInfo) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(fightId: Double, playerInfo: Seq[CharacterMinimalPlusLookInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val playerInfo = {
      val builder = collection.immutable.Seq.newBuilder[CharacterMinimalPlusLookInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterMinimalPlusLookInformations.deserialize(buf)
      }
      builder.result()
    }

    create(fightId, playerInfo)
  }

}

object GuildFightPlayersEnemiesListMessage extends GuildFightPlayersEnemiesListMessage {
  case class MessageImpl(fightId: Double, playerInfo: Seq[CharacterMinimalPlusLookInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, playerInfo: Seq[CharacterMinimalPlusLookInformations.TypeImpl]) = MessageImpl(fightId, playerInfo)

  def apply(fightId: Double, playerInfo: Seq[CharacterMinimalPlusLookInformations.TypeImpl]) = create(fightId, playerInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


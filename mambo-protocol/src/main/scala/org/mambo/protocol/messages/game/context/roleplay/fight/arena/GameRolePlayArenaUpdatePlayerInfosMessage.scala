




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayArenaUpdatePlayerInfosMessage extends MessageDeserializer {
  val messageId = 6301

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayArenaUpdatePlayerInfosMessage.messageId

    val rank: Short
    val bestDailyRank: Short
    val bestRank: Short
    val victoryCount: Short
    val arenaFightcount: Short

    def serialize(buf: Buffer) {
      buf.writeShort(rank)
      buf.writeShort(bestDailyRank)
      buf.writeShort(bestRank)
      buf.writeShort(victoryCount)
      buf.writeShort(arenaFightcount)
    }

  }

  protected def create(rank: Short, bestDailyRank: Short, bestRank: Short, victoryCount: Short, arenaFightcount: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val rank = buf.readShort()
    val bestDailyRank = buf.readShort()
    val bestRank = buf.readShort()
    val victoryCount = buf.readShort()
    val arenaFightcount = buf.readShort()

    create(rank, bestDailyRank, bestRank, victoryCount, arenaFightcount)
  }

}

object GameRolePlayArenaUpdatePlayerInfosMessage extends GameRolePlayArenaUpdatePlayerInfosMessage {
  case class MessageImpl(rank: Short, bestDailyRank: Short, bestRank: Short, victoryCount: Short, arenaFightcount: Short) extends Message
  type Target = MessageImpl

  override def create(rank: Short, bestDailyRank: Short, bestRank: Short, victoryCount: Short, arenaFightcount: Short) = MessageImpl(rank, bestDailyRank, bestRank, victoryCount, arenaFightcount)

  def apply(rank: Short, bestDailyRank: Short, bestRank: Short, victoryCount: Short, arenaFightcount: Short) = create(rank, bestDailyRank, bestRank, victoryCount, arenaFightcount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


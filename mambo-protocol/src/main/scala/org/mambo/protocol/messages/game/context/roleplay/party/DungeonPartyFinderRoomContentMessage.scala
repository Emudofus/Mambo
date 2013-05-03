




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonPartyFinderRoomContentMessage extends MessageDeserializer {
  val messageId = 6247

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonPartyFinderRoomContentMessage.messageId

    val dungeonId: Short
    val players: Seq[DungeonPartyFinderPlayer.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeUShort(players.length)
      for (entry <- players) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(dungeonId: Short, players: Seq[DungeonPartyFinderPlayer.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val players = {
      val builder = collection.immutable.Seq.newBuilder[DungeonPartyFinderPlayer.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += DungeonPartyFinderPlayer.deserialize(buf)
      }
      builder.result()
    }

    create(dungeonId, players)
  }

}

object DungeonPartyFinderRoomContentMessage extends DungeonPartyFinderRoomContentMessage {
  case class MessageImpl(dungeonId: Short, players: Seq[DungeonPartyFinderPlayer.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, players: Seq[DungeonPartyFinderPlayer.TypeImpl]) = MessageImpl(dungeonId, players)

  def apply(dungeonId: Short, players: Seq[DungeonPartyFinderPlayer.TypeImpl]) = create(dungeonId, players)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


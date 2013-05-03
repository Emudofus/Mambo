




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonPartyFinderRoomContentUpdateMessage extends MessageDeserializer {
  val messageId = 6250

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonPartyFinderRoomContentUpdateMessage.messageId

    val dungeonId: Short
    val addedPlayers: Seq[DungeonPartyFinderPlayer.TypeImpl]
    val removedPlayersIds: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeUShort(addedPlayers.length)
      for (entry <- addedPlayers) {
        entry.serialize(buf)
      }
      buf.writeUShort(removedPlayersIds.length)
      for (entry <- removedPlayersIds) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(dungeonId: Short, addedPlayers: Seq[DungeonPartyFinderPlayer.TypeImpl], removedPlayersIds: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val addedPlayers = {
      val builder = collection.immutable.Seq.newBuilder[DungeonPartyFinderPlayer.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += DungeonPartyFinderPlayer.deserialize(buf)
      }
      builder.result()
    }
    val removedPlayersIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(dungeonId, addedPlayers, removedPlayersIds)
  }

}

object DungeonPartyFinderRoomContentUpdateMessage extends DungeonPartyFinderRoomContentUpdateMessage {
  case class MessageImpl(dungeonId: Short, addedPlayers: Seq[DungeonPartyFinderPlayer.TypeImpl], removedPlayersIds: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, addedPlayers: Seq[DungeonPartyFinderPlayer.TypeImpl], removedPlayersIds: Seq[Int]) = MessageImpl(dungeonId, addedPlayers, removedPlayersIds)

  def apply(dungeonId: Short, addedPlayers: Seq[DungeonPartyFinderPlayer.TypeImpl], removedPlayersIds: Seq[Int]) = create(dungeonId, addedPlayers, removedPlayersIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


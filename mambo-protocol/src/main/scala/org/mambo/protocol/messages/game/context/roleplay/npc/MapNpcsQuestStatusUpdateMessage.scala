




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapNpcsQuestStatusUpdateMessage extends MessageDeserializer {
  val messageId = 5642

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MapNpcsQuestStatusUpdateMessage.messageId

    val mapId: Int
    val npcsIdsWithQuest: Seq[Int]
    val questFlags: Seq[GameRolePlayNpcQuestFlag.TypeImpl]
    val npcsIdsWithoutQuest: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeInt(mapId)
      buf.writeUShort(npcsIdsWithQuest.length)
      for (entry <- npcsIdsWithQuest) {
        buf.writeInt(entry)
      }
      buf.writeUShort(questFlags.length)
      for (entry <- questFlags) {
        entry.serialize(buf)
      }
      buf.writeUShort(npcsIdsWithoutQuest.length)
      for (entry <- npcsIdsWithoutQuest) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(mapId: Int, npcsIdsWithQuest: Seq[Int], questFlags: Seq[GameRolePlayNpcQuestFlag.TypeImpl], npcsIdsWithoutQuest: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mapId = buf.readInt()
    val npcsIdsWithQuest = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val questFlags = {
      val builder = collection.immutable.Seq.newBuilder[GameRolePlayNpcQuestFlag.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameRolePlayNpcQuestFlag.deserialize(buf)
      }
      builder.result()
    }
    val npcsIdsWithoutQuest = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(mapId, npcsIdsWithQuest, questFlags, npcsIdsWithoutQuest)
  }

}

object MapNpcsQuestStatusUpdateMessage extends MapNpcsQuestStatusUpdateMessage {
  case class MessageImpl(mapId: Int, npcsIdsWithQuest: Seq[Int], questFlags: Seq[GameRolePlayNpcQuestFlag.TypeImpl], npcsIdsWithoutQuest: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(mapId: Int, npcsIdsWithQuest: Seq[Int], questFlags: Seq[GameRolePlayNpcQuestFlag.TypeImpl], npcsIdsWithoutQuest: Seq[Int]) = MessageImpl(mapId, npcsIdsWithQuest, questFlags, npcsIdsWithoutQuest)

  def apply(mapId: Int, npcsIdsWithQuest: Seq[Int], questFlags: Seq[GameRolePlayNpcQuestFlag.TypeImpl], npcsIdsWithoutQuest: Seq[Int]) = create(mapId, npcsIdsWithQuest, questFlags, npcsIdsWithoutQuest)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


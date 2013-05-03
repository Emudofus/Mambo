




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementDetailedListMessage extends MessageDeserializer {
  val messageId = 6358

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AchievementDetailedListMessage.messageId

    val startedAchievements: Seq[Achievement.TypeImpl]
    val finishedAchievements: Seq[Achievement.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(startedAchievements.length)
      for (entry <- startedAchievements) {
        entry.serialize(buf)
      }
      buf.writeUShort(finishedAchievements.length)
      for (entry <- finishedAchievements) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(startedAchievements: Seq[Achievement.TypeImpl], finishedAchievements: Seq[Achievement.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val startedAchievements = {
      val builder = collection.immutable.Seq.newBuilder[Achievement.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += Achievement.deserialize(buf)
      }
      builder.result()
    }
    val finishedAchievements = {
      val builder = collection.immutable.Seq.newBuilder[Achievement.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += Achievement.deserialize(buf)
      }
      builder.result()
    }

    create(startedAchievements, finishedAchievements)
  }

}

object AchievementDetailedListMessage extends AchievementDetailedListMessage {
  case class MessageImpl(startedAchievements: Seq[Achievement.TypeImpl], finishedAchievements: Seq[Achievement.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(startedAchievements: Seq[Achievement.TypeImpl], finishedAchievements: Seq[Achievement.TypeImpl]) = MessageImpl(startedAchievements, finishedAchievements)

  def apply(startedAchievements: Seq[Achievement.TypeImpl], finishedAchievements: Seq[Achievement.TypeImpl]) = create(startedAchievements, finishedAchievements)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


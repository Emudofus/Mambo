




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementListMessage extends MessageDeserializer {
  val messageId = 6205

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AchievementListMessage.messageId

    val finishedAchievementsIds: Seq[Short]
    val rewardableAchievements: Seq[AchievementRewardable.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(finishedAchievementsIds.length)
      for (entry <- finishedAchievementsIds) {
        buf.writeShort(entry)
      }
      buf.writeUShort(rewardableAchievements.length)
      for (entry <- rewardableAchievements) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(finishedAchievementsIds: Seq[Short], rewardableAchievements: Seq[AchievementRewardable.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val finishedAchievementsIds = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val rewardableAchievements = {
      val builder = collection.immutable.Seq.newBuilder[AchievementRewardable.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += AchievementRewardable.deserialize(buf)
      }
      builder.result()
    }

    create(finishedAchievementsIds, rewardableAchievements)
  }

}

object AchievementListMessage extends AchievementListMessage {
  case class MessageImpl(finishedAchievementsIds: Seq[Short], rewardableAchievements: Seq[AchievementRewardable.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(finishedAchievementsIds: Seq[Short], rewardableAchievements: Seq[AchievementRewardable.TypeImpl]) = MessageImpl(finishedAchievementsIds, rewardableAchievements)

  def apply(finishedAchievementsIds: Seq[Short], rewardableAchievements: Seq[AchievementRewardable.TypeImpl]) = create(finishedAchievementsIds, rewardableAchievements)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


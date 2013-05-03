




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementUpdateMessage extends MessageDeserializer {
  val messageId = 6207

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AchievementUpdateMessage.messageId

    val achievement: Achievement.TypeImpl

    def serialize(buf: Buffer) {
      achievement.serialize(buf)
    }

  }

  protected def create(achievement: Achievement.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val achievement = Achievement.deserialize(buf)

    create(achievement)
  }

}

object AchievementUpdateMessage extends AchievementUpdateMessage {
  case class MessageImpl(achievement: Achievement.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(achievement: Achievement.TypeImpl) = MessageImpl(achievement)

  def apply(achievement: Achievement.TypeImpl) = create(achievement)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


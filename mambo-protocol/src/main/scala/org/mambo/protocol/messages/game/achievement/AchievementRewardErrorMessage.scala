




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementRewardErrorMessage extends MessageDeserializer {
  val messageId = 6375

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AchievementRewardErrorMessage.messageId

    val achievementId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(achievementId)
    }

  }

  protected def create(achievementId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val achievementId = buf.readShort()

    create(achievementId)
  }

}

object AchievementRewardErrorMessage extends AchievementRewardErrorMessage {
  case class MessageImpl(achievementId: Short) extends Message
  type Target = MessageImpl

  override def create(achievementId: Short) = MessageImpl(achievementId)

  def apply(achievementId: Short) = create(achievementId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


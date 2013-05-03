




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendGuildSetWarnOnAchievementCompleteMessage extends MessageDeserializer {
  val messageId = 6382

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FriendGuildSetWarnOnAchievementCompleteMessage.messageId

    val enable: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(enable)
    }

  }

  protected def create(enable: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val enable = buf.readBoolean()

    create(enable)
  }

}

object FriendGuildSetWarnOnAchievementCompleteMessage extends FriendGuildSetWarnOnAchievementCompleteMessage {
  case class MessageImpl(enable: Boolean) extends Message
  type Target = MessageImpl

  override def create(enable: Boolean) = MessageImpl(enable)

  def apply(enable: Boolean) = create(enable)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


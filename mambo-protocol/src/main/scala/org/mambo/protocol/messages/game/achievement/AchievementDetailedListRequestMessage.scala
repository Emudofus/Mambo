




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementDetailedListRequestMessage extends MessageDeserializer {
  val messageId = 6357

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AchievementDetailedListRequestMessage.messageId

    val categoryId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(categoryId)
    }

  }

  protected def create(categoryId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val categoryId = buf.readShort()

    create(categoryId)
  }

}

object AchievementDetailedListRequestMessage extends AchievementDetailedListRequestMessage {
  case class MessageImpl(categoryId: Short) extends Message
  type Target = MessageImpl

  override def create(categoryId: Short) = MessageImpl(categoryId)

  def apply(categoryId: Short) = create(categoryId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


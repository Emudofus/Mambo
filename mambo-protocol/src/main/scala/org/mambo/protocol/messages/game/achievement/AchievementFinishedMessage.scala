




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementFinishedMessage extends MessageDeserializer {
  val messageId = 6208

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AchievementFinishedMessage.messageId

    val id: Short
    val finishedlevel: Short

    def serialize(buf: Buffer) {
      buf.writeShort(id)
      buf.writeShort(finishedlevel)
    }

  }

  protected def create(id: Short, finishedlevel: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readShort()
    val finishedlevel = buf.readShort()

    create(id, finishedlevel)
  }

}

object AchievementFinishedMessage extends AchievementFinishedMessage {
  case class MessageImpl(id: Short, finishedlevel: Short) extends Message
  type Target = MessageImpl

  override def create(id: Short, finishedlevel: Short) = MessageImpl(id, finishedlevel)

  def apply(id: Short, finishedlevel: Short) = create(id, finishedlevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


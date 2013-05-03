




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QuestStartedMessage extends MessageDeserializer {
  val messageId = 6091

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QuestStartedMessage.messageId

    val questId: UShort

    def serialize(buf: Buffer) {
      buf.writeUShort(questId)
    }

  }

  protected def create(questId: UShort): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val questId = buf.readUShort()

    create(questId)
  }

}

object QuestStartedMessage extends QuestStartedMessage {
  case class MessageImpl(questId: UShort) extends Message
  type Target = MessageImpl

  override def create(questId: UShort) = MessageImpl(questId)

  def apply(questId: UShort) = create(questId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


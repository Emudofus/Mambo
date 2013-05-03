




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QuestObjectiveValidationMessage extends MessageDeserializer {
  val messageId = 6085

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QuestObjectiveValidationMessage.messageId

    val questId: Short
    val objectiveId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(questId)
      buf.writeShort(objectiveId)
    }

  }

  protected def create(questId: Short, objectiveId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val questId = buf.readShort()
    val objectiveId = buf.readShort()

    create(questId, objectiveId)
  }

}

object QuestObjectiveValidationMessage extends QuestObjectiveValidationMessage {
  case class MessageImpl(questId: Short, objectiveId: Short) extends Message
  type Target = MessageImpl

  override def create(questId: Short, objectiveId: Short) = MessageImpl(questId, objectiveId)

  def apply(questId: Short, objectiveId: Short) = create(questId, objectiveId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


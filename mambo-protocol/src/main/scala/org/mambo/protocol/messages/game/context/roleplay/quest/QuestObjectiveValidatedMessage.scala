




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QuestObjectiveValidatedMessage extends MessageDeserializer {
  val messageId = 6098

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QuestObjectiveValidatedMessage.messageId

    val questId: UShort
    val objectiveId: UShort

    def serialize(buf: Buffer) {
      buf.writeUShort(questId)
      buf.writeUShort(objectiveId)
    }

  }

  protected def create(questId: UShort, objectiveId: UShort): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val questId = buf.readUShort()
    val objectiveId = buf.readUShort()

    create(questId, objectiveId)
  }

}

object QuestObjectiveValidatedMessage extends QuestObjectiveValidatedMessage {
  case class MessageImpl(questId: UShort, objectiveId: UShort) extends Message
  type Target = MessageImpl

  override def create(questId: UShort, objectiveId: UShort) = MessageImpl(questId, objectiveId)

  def apply(questId: UShort, objectiveId: UShort) = create(questId, objectiveId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


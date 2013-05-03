




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QuestStepValidatedMessage extends MessageDeserializer {
  val messageId = 6099

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QuestStepValidatedMessage.messageId

    val questId: UShort
    val stepId: UShort

    def serialize(buf: Buffer) {
      buf.writeUShort(questId)
      buf.writeUShort(stepId)
    }

  }

  protected def create(questId: UShort, stepId: UShort): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val questId = buf.readUShort()
    val stepId = buf.readUShort()

    create(questId, stepId)
  }

}

object QuestStepValidatedMessage extends QuestStepValidatedMessage {
  case class MessageImpl(questId: UShort, stepId: UShort) extends Message
  type Target = MessageImpl

  override def create(questId: UShort, stepId: UShort) = MessageImpl(questId, stepId)

  def apply(questId: UShort, stepId: UShort) = create(questId, stepId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


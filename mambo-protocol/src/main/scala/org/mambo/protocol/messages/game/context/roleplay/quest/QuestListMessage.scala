




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QuestListMessage extends MessageDeserializer {
  val messageId = 5626

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QuestListMessage.messageId

    val finishedQuestsIds: Seq[Short]
    val finishedQuestsCounts: Seq[Short]
    val activeQuests: Seq[QuestActiveInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(finishedQuestsIds.length)
      for (entry <- finishedQuestsIds) {
        buf.writeShort(entry)
      }
      buf.writeUShort(finishedQuestsCounts.length)
      for (entry <- finishedQuestsCounts) {
        buf.writeShort(entry)
      }
      buf.writeUShort(activeQuests.length)
      for (entry <- activeQuests) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(finishedQuestsIds: Seq[Short], finishedQuestsCounts: Seq[Short], activeQuests: Seq[QuestActiveInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val finishedQuestsIds = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val finishedQuestsCounts = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val activeQuests = {
      val builder = collection.immutable.Seq.newBuilder[QuestActiveInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[QuestActiveInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(finishedQuestsIds, finishedQuestsCounts, activeQuests)
  }

}

object QuestListMessage extends QuestListMessage {
  case class MessageImpl(finishedQuestsIds: Seq[Short], finishedQuestsCounts: Seq[Short], activeQuests: Seq[QuestActiveInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(finishedQuestsIds: Seq[Short], finishedQuestsCounts: Seq[Short], activeQuests: Seq[QuestActiveInformations.TypeImpl]) = MessageImpl(finishedQuestsIds, finishedQuestsCounts, activeQuests)

  def apply(finishedQuestsIds: Seq[Short], finishedQuestsCounts: Seq[Short], activeQuests: Seq[QuestActiveInformations.TypeImpl]) = create(finishedQuestsIds, finishedQuestsCounts, activeQuests)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


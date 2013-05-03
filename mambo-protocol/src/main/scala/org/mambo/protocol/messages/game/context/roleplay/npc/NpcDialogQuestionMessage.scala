




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NpcDialogQuestionMessage extends MessageDeserializer {
  val messageId = 5617

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NpcDialogQuestionMessage.messageId

    val msgId: Short
    val dialogParams: Seq[String]
    val visibleReplies: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeShort(msgId)
      buf.writeUShort(dialogParams.length)
      for (entry <- dialogParams) {
        buf.writeString(entry)
      }
      buf.writeUShort(visibleReplies.length)
      for (entry <- visibleReplies) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(msgId: Short, dialogParams: Seq[String], visibleReplies: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val msgId = buf.readShort()
    val dialogParams = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }
    val visibleReplies = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(msgId, dialogParams, visibleReplies)
  }

}

object NpcDialogQuestionMessage extends NpcDialogQuestionMessage {
  case class MessageImpl(msgId: Short, dialogParams: Seq[String], visibleReplies: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(msgId: Short, dialogParams: Seq[String], visibleReplies: Seq[Short]) = MessageImpl(msgId, dialogParams, visibleReplies)

  def apply(msgId: Short, dialogParams: Seq[String], visibleReplies: Seq[Short]) = create(msgId, dialogParams, visibleReplies)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


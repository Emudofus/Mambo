




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NpcDialogReplyMessage extends MessageDeserializer {
  val messageId = 5616

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NpcDialogReplyMessage.messageId

    val replyId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(replyId)
    }

  }

  protected def create(replyId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val replyId = buf.readShort()

    create(replyId)
  }

}

object NpcDialogReplyMessage extends NpcDialogReplyMessage {
  case class MessageImpl(replyId: Short) extends Message
  type Target = MessageImpl

  override def create(replyId: Short) = MessageImpl(replyId)

  def apply(replyId: Short) = create(replyId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


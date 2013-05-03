




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NewMailMessage extends MailStatusMessage {
  override val messageId = 6292

  protected trait Message extends MailStatusMessage.Message with Serializable {
    override val messageId = NewMailMessage.messageId

    val sendersAccountId: Seq[Int]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(sendersAccountId.length)
      for (entry <- sendersAccountId) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(unread: Short, total: Short, sendersAccountId: Seq[Int]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val unread = buf.readShort()
    val total = buf.readShort()
    val sendersAccountId = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(unread, total, sendersAccountId)
  }

}

object NewMailMessage extends NewMailMessage {
  case class MessageImpl(unread: Short, total: Short, sendersAccountId: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(unread: Short, total: Short, sendersAccountId: Seq[Int]) = MessageImpl(unread, total, sendersAccountId)

  def apply(unread: Short, total: Short, sendersAccountId: Seq[Int]) = create(unread, total, sendersAccountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NotificationListMessage extends MessageDeserializer {
  val messageId = 6087

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NotificationListMessage.messageId

    val flags: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(flags.length)
      for (entry <- flags) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(flags: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flags = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(flags)
  }

}

object NotificationListMessage extends NotificationListMessage {
  case class MessageImpl(flags: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(flags: Seq[Int]) = MessageImpl(flags)

  def apply(flags: Seq[Int]) = create(flags)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


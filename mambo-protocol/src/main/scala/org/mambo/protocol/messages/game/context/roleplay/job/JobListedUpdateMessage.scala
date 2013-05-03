




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobListedUpdateMessage extends MessageDeserializer {
  val messageId = 6016

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobListedUpdateMessage.messageId

    val addedOrDeleted: Boolean
    val jobId: Byte

    def serialize(buf: Buffer) {
      buf.writeBoolean(addedOrDeleted)
      buf.writeByte(jobId)
    }

  }

  protected def create(addedOrDeleted: Boolean, jobId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val addedOrDeleted = buf.readBoolean()
    val jobId = buf.readByte()

    create(addedOrDeleted, jobId)
  }

}

object JobListedUpdateMessage extends JobListedUpdateMessage {
  case class MessageImpl(addedOrDeleted: Boolean, jobId: Byte) extends Message
  type Target = MessageImpl

  override def create(addedOrDeleted: Boolean, jobId: Byte) = MessageImpl(addedOrDeleted, jobId)

  def apply(addedOrDeleted: Boolean, jobId: Byte) = create(addedOrDeleted, jobId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


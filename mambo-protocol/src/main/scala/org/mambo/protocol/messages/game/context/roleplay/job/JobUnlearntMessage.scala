




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobUnlearntMessage extends MessageDeserializer {
  val messageId = 5657

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobUnlearntMessage.messageId

    val jobId: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(jobId)
    }

  }

  protected def create(jobId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobId = buf.readByte()

    create(jobId)
  }

}

object JobUnlearntMessage extends JobUnlearntMessage {
  case class MessageImpl(jobId: Byte) extends Message
  type Target = MessageImpl

  override def create(jobId: Byte) = MessageImpl(jobId)

  def apply(jobId: Byte) = create(jobId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


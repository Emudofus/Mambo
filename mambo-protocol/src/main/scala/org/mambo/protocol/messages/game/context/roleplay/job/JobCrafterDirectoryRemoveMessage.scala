




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectoryRemoveMessage extends MessageDeserializer {
  val messageId = 5653

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectoryRemoveMessage.messageId

    val jobId: Byte
    val playerId: Int

    def serialize(buf: Buffer) {
      buf.writeByte(jobId)
      buf.writeInt(playerId)
    }

  }

  protected def create(jobId: Byte, playerId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobId = buf.readByte()
    val playerId = buf.readInt()

    create(jobId, playerId)
  }

}

object JobCrafterDirectoryRemoveMessage extends JobCrafterDirectoryRemoveMessage {
  case class MessageImpl(jobId: Byte, playerId: Int) extends Message
  type Target = MessageImpl

  override def create(jobId: Byte, playerId: Int) = MessageImpl(jobId, playerId)

  def apply(jobId: Byte, playerId: Int) = create(jobId, playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


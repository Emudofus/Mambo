




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectoryEntryRequestMessage extends MessageDeserializer {
  val messageId = 6043

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectoryEntryRequestMessage.messageId

    val playerId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(playerId)
    }

  }

  protected def create(playerId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerId = buf.readInt()

    create(playerId)
  }

}

object JobCrafterDirectoryEntryRequestMessage extends JobCrafterDirectoryEntryRequestMessage {
  case class MessageImpl(playerId: Int) extends Message
  type Target = MessageImpl

  override def create(playerId: Int) = MessageImpl(playerId)

  def apply(playerId: Int) = create(playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


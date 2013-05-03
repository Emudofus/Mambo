




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonPartyFinderListenRequestMessage extends MessageDeserializer {
  val messageId = 6246

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonPartyFinderListenRequestMessage.messageId

    val dungeonId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
    }

  }

  protected def create(dungeonId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()

    create(dungeonId)
  }

}

object DungeonPartyFinderListenRequestMessage extends DungeonPartyFinderListenRequestMessage {
  case class MessageImpl(dungeonId: Short) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short) = MessageImpl(dungeonId)

  def apply(dungeonId: Short) = create(dungeonId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


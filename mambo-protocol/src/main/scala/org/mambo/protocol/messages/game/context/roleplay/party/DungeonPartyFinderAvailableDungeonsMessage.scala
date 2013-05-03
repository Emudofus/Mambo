




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonPartyFinderAvailableDungeonsMessage extends MessageDeserializer {
  val messageId = 6242

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonPartyFinderAvailableDungeonsMessage.messageId

    val dungeonIds: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(dungeonIds.length)
      for (entry <- dungeonIds) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(dungeonIds: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonIds = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(dungeonIds)
  }

}

object DungeonPartyFinderAvailableDungeonsMessage extends DungeonPartyFinderAvailableDungeonsMessage {
  case class MessageImpl(dungeonIds: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(dungeonIds: Seq[Short]) = MessageImpl(dungeonIds)

  def apply(dungeonIds: Seq[Short]) = create(dungeonIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


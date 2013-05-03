




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonKeyRingUpdateMessage extends MessageDeserializer {
  val messageId = 6296

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonKeyRingUpdateMessage.messageId

    val dungeonId: Short
    val available: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(dungeonId)
      buf.writeBoolean(available)
    }

  }

  protected def create(dungeonId: Short, available: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readShort()
    val available = buf.readBoolean()

    create(dungeonId, available)
  }

}

object DungeonKeyRingUpdateMessage extends DungeonKeyRingUpdateMessage {
  case class MessageImpl(dungeonId: Short, available: Boolean) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Short, available: Boolean) = MessageImpl(dungeonId, available)

  def apply(dungeonId: Short, available: Boolean) = create(dungeonId, available)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


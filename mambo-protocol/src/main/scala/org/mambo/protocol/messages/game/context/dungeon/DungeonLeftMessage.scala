




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonLeftMessage extends MessageDeserializer {
  val messageId = 6149

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonLeftMessage.messageId

    val dungeonId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(dungeonId)
    }

  }

  protected def create(dungeonId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readInt()

    create(dungeonId)
  }

}

object DungeonLeftMessage extends DungeonLeftMessage {
  case class MessageImpl(dungeonId: Int) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Int) = MessageImpl(dungeonId)

  def apply(dungeonId: Int) = create(dungeonId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


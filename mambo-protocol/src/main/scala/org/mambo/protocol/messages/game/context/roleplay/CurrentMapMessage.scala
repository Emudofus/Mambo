




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CurrentMapMessage extends MessageDeserializer {
  val messageId = 220

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CurrentMapMessage.messageId

    val mapId: Int
    val mapKey: String

    def serialize(buf: Buffer) {
      buf.writeInt(mapId)
      buf.writeString(mapKey)
    }

  }

  protected def create(mapId: Int, mapKey: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mapId = buf.readInt()
    val mapKey = buf.readString()

    create(mapId, mapKey)
  }

}

object CurrentMapMessage extends CurrentMapMessage {
  case class MessageImpl(mapId: Int, mapKey: String) extends Message
  type Target = MessageImpl

  override def create(mapId: Int, mapKey: String) = MessageImpl(mapId, mapKey)

  def apply(mapId: Int, mapKey: String) = create(mapId, mapKey)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChangeMapMessage extends MessageDeserializer {
  val messageId = 221

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChangeMapMessage.messageId

    val mapId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(mapId)
    }

  }

  protected def create(mapId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mapId = buf.readInt()

    create(mapId)
  }

}

object ChangeMapMessage extends ChangeMapMessage {
  case class MessageImpl(mapId: Int) extends Message
  type Target = MessageImpl

  override def create(mapId: Int) = MessageImpl(mapId)

  def apply(mapId: Int) = create(mapId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


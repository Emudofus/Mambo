




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ServerSelectionMessage extends MessageDeserializer {
  val messageId = 40

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ServerSelectionMessage.messageId

    val serverId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(serverId)
    }

  }

  protected def create(serverId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val serverId = buf.readShort()

    create(serverId)
  }

}

object ServerSelectionMessage extends ServerSelectionMessage {
  case class MessageImpl(serverId: Short) extends Message
  type Target = MessageImpl

  override def create(serverId: Short) = MessageImpl(serverId)

  def apply(serverId: Short) = create(serverId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


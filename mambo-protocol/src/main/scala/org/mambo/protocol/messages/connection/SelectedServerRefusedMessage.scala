




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SelectedServerRefusedMessage extends MessageDeserializer {
  val messageId = 41

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SelectedServerRefusedMessage.messageId

    val serverId: Short
    val error: Byte
    val serverStatus: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(serverId)
      buf.writeByte(error)
      buf.writeByte(serverStatus)
    }

  }

  protected def create(serverId: Short, error: Byte, serverStatus: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val serverId = buf.readShort()
    val error = buf.readByte()
    val serverStatus = buf.readByte()

    create(serverId, error, serverStatus)
  }

}

object SelectedServerRefusedMessage extends SelectedServerRefusedMessage {
  case class MessageImpl(serverId: Short, error: Byte, serverStatus: Byte) extends Message
  type Target = MessageImpl

  override def create(serverId: Short, error: Byte, serverStatus: Byte) = MessageImpl(serverId, error, serverStatus)

  def apply(serverId: Short, error: Byte, serverStatus: Byte) = create(serverId, error, serverStatus)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChannelEnablingMessage extends MessageDeserializer {
  val messageId = 890

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChannelEnablingMessage.messageId

    val channel: Byte
    val enable: Boolean

    def serialize(buf: Buffer) {
      buf.writeByte(channel)
      buf.writeBoolean(enable)
    }

  }

  protected def create(channel: Byte, enable: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val channel = buf.readByte()
    val enable = buf.readBoolean()

    create(channel, enable)
  }

}

object ChannelEnablingMessage extends ChannelEnablingMessage {
  case class MessageImpl(channel: Byte, enable: Boolean) extends Message
  type Target = MessageImpl

  override def create(channel: Byte, enable: Boolean) = MessageImpl(channel, enable)

  def apply(channel: Byte, enable: Boolean) = create(channel, enable)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


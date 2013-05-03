




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DownloadSetSpeedRequestMessage extends MessageDeserializer {
  val messageId = 1512

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DownloadSetSpeedRequestMessage.messageId

    val downloadSpeed: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(downloadSpeed)
    }

  }

  protected def create(downloadSpeed: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val downloadSpeed = buf.readByte()

    create(downloadSpeed)
  }

}

object DownloadSetSpeedRequestMessage extends DownloadSetSpeedRequestMessage {
  case class MessageImpl(downloadSpeed: Byte) extends Message
  type Target = MessageImpl

  override def create(downloadSpeed: Byte) = MessageImpl(downloadSpeed)

  def apply(downloadSpeed: Byte) = create(downloadSpeed)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


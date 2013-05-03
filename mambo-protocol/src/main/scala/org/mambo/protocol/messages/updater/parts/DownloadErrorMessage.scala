




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DownloadErrorMessage extends MessageDeserializer {
  val messageId = 1513

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DownloadErrorMessage.messageId

    val errorId: Byte
    val message: String
    val helpUrl: String

    def serialize(buf: Buffer) {
      buf.writeByte(errorId)
      buf.writeString(message)
      buf.writeString(helpUrl)
    }

  }

  protected def create(errorId: Byte, message: String, helpUrl: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val errorId = buf.readByte()
    val message = buf.readString()
    val helpUrl = buf.readString()

    create(errorId, message, helpUrl)
  }

}

object DownloadErrorMessage extends DownloadErrorMessage {
  case class MessageImpl(errorId: Byte, message: String, helpUrl: String) extends Message
  type Target = MessageImpl

  override def create(errorId: Byte, message: String, helpUrl: String) = MessageImpl(errorId, message, helpUrl)

  def apply(errorId: Byte, message: String, helpUrl: String) = create(errorId, message, helpUrl)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


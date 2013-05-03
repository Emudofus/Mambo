




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PopupWarningMessage extends MessageDeserializer {
  val messageId = 6134

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PopupWarningMessage.messageId

    val lockDuration: UByte
    val author: String
    val content: String

    def serialize(buf: Buffer) {
      buf.writeUByte(lockDuration)
      buf.writeString(author)
      buf.writeString(content)
    }

  }

  protected def create(lockDuration: UByte, author: String, content: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val lockDuration = buf.readUByte()
    val author = buf.readString()
    val content = buf.readString()

    create(lockDuration, author, content)
  }

}

object PopupWarningMessage extends PopupWarningMessage {
  case class MessageImpl(lockDuration: UByte, author: String, content: String) extends Message
  type Target = MessageImpl

  override def create(lockDuration: UByte, author: String, content: String) = MessageImpl(lockDuration, author, content)

  def apply(lockDuration: UByte, author: String, content: String) = create(lockDuration, author, content)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:30
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ConsoleMessage extends MessageDeserializer {
  val messageId = 75

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ConsoleMessage.messageId

    val theType: Byte
    val content: String

    def serialize(buf: Buffer) {
      buf.writeByte(theType)
      buf.writeString(content)
    }

  }

  protected def create(theType: Byte, content: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = buf.readByte()
    val content = buf.readString()

    create(theType, content)
  }

}

object ConsoleMessage extends ConsoleMessage {
  case class MessageImpl(theType: Byte, content: String) extends Message
  type Target = MessageImpl

  override def create(theType: Byte, content: String) = MessageImpl(theType, content)

  def apply(theType: Byte, content: String) = create(theType, content)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


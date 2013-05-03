




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ContactLookRequestMessage extends MessageDeserializer {
  val messageId = 5932

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ContactLookRequestMessage.messageId

    val requestId: UByte
    val contactType: Byte

    def serialize(buf: Buffer) {
      buf.writeUByte(requestId)
      buf.writeByte(contactType)
    }

  }

  protected def create(requestId: UByte, contactType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val requestId = buf.readUByte()
    val contactType = buf.readByte()

    create(requestId, contactType)
  }

}

object ContactLookRequestMessage extends ContactLookRequestMessage {
  case class MessageImpl(requestId: UByte, contactType: Byte) extends Message
  type Target = MessageImpl

  override def create(requestId: UByte, contactType: Byte) = MessageImpl(requestId, contactType)

  def apply(requestId: UByte, contactType: Byte) = create(requestId, contactType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


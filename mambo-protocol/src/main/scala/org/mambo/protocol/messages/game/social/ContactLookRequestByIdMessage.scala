




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ContactLookRequestByIdMessage extends ContactLookRequestMessage {
  override val messageId = 5935

  protected trait Message extends ContactLookRequestMessage.Message with Serializable {
    override val messageId = ContactLookRequestByIdMessage.messageId

    val playerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(playerId)
    }

  }

  protected def create(requestId: UByte, contactType: Byte, playerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val requestId = buf.readUByte()
    val contactType = buf.readByte()
    val playerId = buf.readInt()

    create(requestId, contactType, playerId)
  }

}

object ContactLookRequestByIdMessage extends ContactLookRequestByIdMessage {
  case class MessageImpl(requestId: UByte, contactType: Byte, playerId: Int) extends Message
  type Target = MessageImpl

  override def create(requestId: UByte, contactType: Byte, playerId: Int) = MessageImpl(requestId, contactType, playerId)

  def apply(requestId: UByte, contactType: Byte, playerId: Int) = create(requestId, contactType, playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


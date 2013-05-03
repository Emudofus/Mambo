




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ContactLookErrorMessage extends MessageDeserializer {
  val messageId = 6045

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ContactLookErrorMessage.messageId

    val requestId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(requestId)
    }

  }

  protected def create(requestId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val requestId = buf.readInt()

    create(requestId)
  }

}

object ContactLookErrorMessage extends ContactLookErrorMessage {
  case class MessageImpl(requestId: Int) extends Message
  type Target = MessageImpl

  override def create(requestId: Int) = MessageImpl(requestId)

  def apply(requestId: Int) = create(requestId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


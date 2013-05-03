




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EmotePlayErrorMessage extends MessageDeserializer {
  val messageId = 5688

  protected trait Message extends BaseMessage with Serializable {
    val messageId = EmotePlayErrorMessage.messageId

    val emoteId: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(emoteId)
    }

  }

  protected def create(emoteId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val emoteId = buf.readByte()

    create(emoteId)
  }

}

object EmotePlayErrorMessage extends EmotePlayErrorMessage {
  case class MessageImpl(emoteId: Byte) extends Message
  type Target = MessageImpl

  override def create(emoteId: Byte) = MessageImpl(emoteId)

  def apply(emoteId: Byte) = create(emoteId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


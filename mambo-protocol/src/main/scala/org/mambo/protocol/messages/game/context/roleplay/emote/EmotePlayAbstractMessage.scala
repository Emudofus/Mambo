




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EmotePlayAbstractMessage extends MessageDeserializer {
  val messageId = 5690

  protected trait Message extends BaseMessage with Serializable {
    val messageId = EmotePlayAbstractMessage.messageId

    val emoteId: Byte
    val emoteStartTime: Double

    def serialize(buf: Buffer) {
      buf.writeByte(emoteId)
      buf.writeDouble(emoteStartTime)
    }

  }

  protected def create(emoteId: Byte, emoteStartTime: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val emoteId = buf.readByte()
    val emoteStartTime = buf.readDouble()

    create(emoteId, emoteStartTime)
  }

}

object EmotePlayAbstractMessage extends EmotePlayAbstractMessage {
  case class MessageImpl(emoteId: Byte, emoteStartTime: Double) extends Message
  type Target = MessageImpl

  override def create(emoteId: Byte, emoteStartTime: Double) = MessageImpl(emoteId, emoteStartTime)

  def apply(emoteId: Byte, emoteStartTime: Double) = create(emoteId, emoteStartTime)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


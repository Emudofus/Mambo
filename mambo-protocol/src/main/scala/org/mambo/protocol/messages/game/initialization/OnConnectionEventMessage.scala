




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait OnConnectionEventMessage extends MessageDeserializer {
  val messageId = 5726

  protected trait Message extends BaseMessage with Serializable {
    val messageId = OnConnectionEventMessage.messageId

    val eventType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(eventType)
    }

  }

  protected def create(eventType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val eventType = buf.readByte()

    create(eventType)
  }

}

object OnConnectionEventMessage extends OnConnectionEventMessage {
  case class MessageImpl(eventType: Byte) extends Message
  type Target = MessageImpl

  override def create(eventType: Byte) = MessageImpl(eventType)

  def apply(eventType: Byte) = create(eventType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


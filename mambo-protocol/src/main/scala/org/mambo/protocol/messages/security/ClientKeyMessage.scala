




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ClientKeyMessage extends MessageDeserializer {
  val messageId = 5607

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ClientKeyMessage.messageId

    val key: String

    def serialize(buf: Buffer) {
      buf.writeString(key)
    }

  }

  protected def create(key: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val key = buf.readString()

    create(key)
  }

}

object ClientKeyMessage extends ClientKeyMessage {
  case class MessageImpl(key: String) extends Message
  type Target = MessageImpl

  override def create(key: String) = MessageImpl(key)

  def apply(key: String) = create(key)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


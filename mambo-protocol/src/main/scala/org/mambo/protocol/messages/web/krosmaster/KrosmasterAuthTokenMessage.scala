




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait KrosmasterAuthTokenMessage extends MessageDeserializer {
  val messageId = 6351

  protected trait Message extends BaseMessage with Serializable {
    val messageId = KrosmasterAuthTokenMessage.messageId

    val token: String

    def serialize(buf: Buffer) {
      buf.writeString(token)
    }

  }

  protected def create(token: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val token = buf.readString()

    create(token)
  }

}

object KrosmasterAuthTokenMessage extends KrosmasterAuthTokenMessage {
  case class MessageImpl(token: String) extends Message
  type Target = MessageImpl

  override def create(token: String) = MessageImpl(token)

  def apply(token: String) = create(token)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


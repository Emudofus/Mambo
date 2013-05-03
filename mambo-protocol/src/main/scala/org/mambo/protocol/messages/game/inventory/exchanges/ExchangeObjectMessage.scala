




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectMessage extends MessageDeserializer {
  val messageId = 5515

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeObjectMessage.messageId

    val remote: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(remote)
    }

  }

  protected def create(remote: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val remote = buf.readBoolean()

    create(remote)
  }

}

object ExchangeObjectMessage extends ExchangeObjectMessage {
  case class MessageImpl(remote: Boolean) extends Message
  type Target = MessageImpl

  override def create(remote: Boolean) = MessageImpl(remote)

  def apply(remote: Boolean) = create(remote)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


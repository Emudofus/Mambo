




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeIsReadyMessage extends MessageDeserializer {
  val messageId = 5509

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeIsReadyMessage.messageId

    val id: Int
    val ready: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      buf.writeBoolean(ready)
    }

  }

  protected def create(id: Int, ready: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val ready = buf.readBoolean()

    create(id, ready)
  }

}

object ExchangeIsReadyMessage extends ExchangeIsReadyMessage {
  case class MessageImpl(id: Int, ready: Boolean) extends Message
  type Target = MessageImpl

  override def create(id: Int, ready: Boolean) = MessageImpl(id, ready)

  def apply(id: Int, ready: Boolean) = create(id, ready)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


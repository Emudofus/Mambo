




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeReadyMessage extends MessageDeserializer {
  val messageId = 5511

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeReadyMessage.messageId

    val ready: Boolean
    val step: Short

    def serialize(buf: Buffer) {
      buf.writeBoolean(ready)
      buf.writeShort(step)
    }

  }

  protected def create(ready: Boolean, step: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ready = buf.readBoolean()
    val step = buf.readShort()

    create(ready, step)
  }

}

object ExchangeReadyMessage extends ExchangeReadyMessage {
  case class MessageImpl(ready: Boolean, step: Short) extends Message
  type Target = MessageImpl

  override def create(ready: Boolean, step: Short) = MessageImpl(ready, step)

  def apply(ready: Boolean, step: Short) = create(ready, step)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


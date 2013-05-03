




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeReplayMessage extends MessageDeserializer {
  val messageId = 6002

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeReplayMessage.messageId

    val count: Int

    def serialize(buf: Buffer) {
      buf.writeInt(count)
    }

  }

  protected def create(count: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val count = buf.readInt()

    create(count)
  }

}

object ExchangeReplayMessage extends ExchangeReplayMessage {
  case class MessageImpl(count: Int) extends Message
  type Target = MessageImpl

  override def create(count: Int) = MessageImpl(count)

  def apply(count: Int) = create(count)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeWaitingResultMessage extends MessageDeserializer {
  val messageId = 5786

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeWaitingResultMessage.messageId

    val bwait: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(bwait)
    }

  }

  protected def create(bwait: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val bwait = buf.readBoolean()

    create(bwait)
  }

}

object ExchangeWaitingResultMessage extends ExchangeWaitingResultMessage {
  case class MessageImpl(bwait: Boolean) extends Message
  type Target = MessageImpl

  override def create(bwait: Boolean) = MessageImpl(bwait)

  def apply(bwait: Boolean) = create(bwait)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeKamaModifiedMessage extends ExchangeObjectMessage {
  override val messageId = 5521

  protected trait Message extends ExchangeObjectMessage.Message with Serializable {
    override val messageId = ExchangeKamaModifiedMessage.messageId

    val quantity: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(quantity)
    }

  }

  protected def create(remote: Boolean, quantity: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val remote = buf.readBoolean()
    val quantity = buf.readInt()

    create(remote, quantity)
  }

}

object ExchangeKamaModifiedMessage extends ExchangeKamaModifiedMessage {
  case class MessageImpl(remote: Boolean, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(remote: Boolean, quantity: Int) = MessageImpl(remote, quantity)

  def apply(remote: Boolean, quantity: Int) = create(remote, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


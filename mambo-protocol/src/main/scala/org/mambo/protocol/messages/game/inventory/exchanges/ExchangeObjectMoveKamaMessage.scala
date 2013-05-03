




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectMoveKamaMessage extends MessageDeserializer {
  val messageId = 5520

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeObjectMoveKamaMessage.messageId

    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeInt(quantity)
    }

  }

  protected def create(quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val quantity = buf.readInt()

    create(quantity)
  }

}

object ExchangeObjectMoveKamaMessage extends ExchangeObjectMoveKamaMessage {
  case class MessageImpl(quantity: Int) extends Message
  type Target = MessageImpl

  override def create(quantity: Int) = MessageImpl(quantity)

  def apply(quantity: Int) = create(quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


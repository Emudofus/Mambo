




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockSellRequestMessage extends MessageDeserializer {
  val messageId = 5953

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockSellRequestMessage.messageId

    val price: Int

    def serialize(buf: Buffer) {
      buf.writeInt(price)
    }

  }

  protected def create(price: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val price = buf.readInt()

    create(price)
  }

}

object PaddockSellRequestMessage extends PaddockSellRequestMessage {
  case class MessageImpl(price: Int) extends Message
  type Target = MessageImpl

  override def create(price: Int) = MessageImpl(price)

  def apply(price: Int) = create(price)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


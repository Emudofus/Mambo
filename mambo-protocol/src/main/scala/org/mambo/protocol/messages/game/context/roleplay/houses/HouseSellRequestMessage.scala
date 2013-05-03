




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseSellRequestMessage extends MessageDeserializer {
  val messageId = 5697

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseSellRequestMessage.messageId

    val amount: Int

    def serialize(buf: Buffer) {
      buf.writeInt(amount)
    }

  }

  protected def create(amount: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val amount = buf.readInt()

    create(amount)
  }

}

object HouseSellRequestMessage extends HouseSellRequestMessage {
  case class MessageImpl(amount: Int) extends Message
  type Target = MessageImpl

  override def create(amount: Int) = MessageImpl(amount)

  def apply(amount: Int) = create(amount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


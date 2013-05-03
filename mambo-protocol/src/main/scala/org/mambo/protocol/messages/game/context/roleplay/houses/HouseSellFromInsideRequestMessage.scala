




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseSellFromInsideRequestMessage extends HouseSellRequestMessage {
  override val messageId = 5884

  protected trait Message extends HouseSellRequestMessage.Message with Serializable {
    override val messageId = HouseSellFromInsideRequestMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val amount = buf.readInt()

    create(amount)
  }

}

object HouseSellFromInsideRequestMessage extends HouseSellFromInsideRequestMessage {
  case class MessageImpl(amount: Int) extends Message
  type Target = MessageImpl

  override def create(amount: Int) = MessageImpl(amount)

  def apply(amount: Int) = create(amount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


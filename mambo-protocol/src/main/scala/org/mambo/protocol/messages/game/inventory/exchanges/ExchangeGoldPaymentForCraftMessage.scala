




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeGoldPaymentForCraftMessage extends MessageDeserializer {
  val messageId = 5833

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeGoldPaymentForCraftMessage.messageId

    val onlySuccess: Boolean
    val goldSum: Int

    def serialize(buf: Buffer) {
      buf.writeBoolean(onlySuccess)
      buf.writeInt(goldSum)
    }

  }

  protected def create(onlySuccess: Boolean, goldSum: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val onlySuccess = buf.readBoolean()
    val goldSum = buf.readInt()

    create(onlySuccess, goldSum)
  }

}

object ExchangeGoldPaymentForCraftMessage extends ExchangeGoldPaymentForCraftMessage {
  case class MessageImpl(onlySuccess: Boolean, goldSum: Int) extends Message
  type Target = MessageImpl

  override def create(onlySuccess: Boolean, goldSum: Int) = MessageImpl(onlySuccess, goldSum)

  def apply(onlySuccess: Boolean, goldSum: Int) = create(onlySuccess, goldSum)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


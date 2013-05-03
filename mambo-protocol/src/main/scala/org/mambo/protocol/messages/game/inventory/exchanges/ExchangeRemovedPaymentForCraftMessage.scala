




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeRemovedPaymentForCraftMessage extends MessageDeserializer {
  val messageId = 6031

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeRemovedPaymentForCraftMessage.messageId

    val onlySuccess: Boolean
    val objectUID: Int

    def serialize(buf: Buffer) {
      buf.writeBoolean(onlySuccess)
      buf.writeInt(objectUID)
    }

  }

  protected def create(onlySuccess: Boolean, objectUID: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val onlySuccess = buf.readBoolean()
    val objectUID = buf.readInt()

    create(onlySuccess, objectUID)
  }

}

object ExchangeRemovedPaymentForCraftMessage extends ExchangeRemovedPaymentForCraftMessage {
  case class MessageImpl(onlySuccess: Boolean, objectUID: Int) extends Message
  type Target = MessageImpl

  override def create(onlySuccess: Boolean, objectUID: Int) = MessageImpl(onlySuccess, objectUID)

  def apply(onlySuccess: Boolean, objectUID: Int) = create(onlySuccess, objectUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


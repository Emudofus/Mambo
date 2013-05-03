




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeModifiedPaymentForCraftMessage extends MessageDeserializer {
  val messageId = 5832

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeModifiedPaymentForCraftMessage.messageId

    val onlySuccess: Boolean
    val theObject: ObjectItemNotInContainer.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeBoolean(onlySuccess)
      theObject.serialize(buf)
    }

  }

  protected def create(onlySuccess: Boolean, theObject: ObjectItemNotInContainer.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val onlySuccess = buf.readBoolean()
    val theObject = ObjectItemNotInContainer.deserialize(buf)

    create(onlySuccess, theObject)
  }

}

object ExchangeModifiedPaymentForCraftMessage extends ExchangeModifiedPaymentForCraftMessage {
  case class MessageImpl(onlySuccess: Boolean, theObject: ObjectItemNotInContainer.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(onlySuccess: Boolean, theObject: ObjectItemNotInContainer.TypeImpl) = MessageImpl(onlySuccess, theObject)

  def apply(onlySuccess: Boolean, theObject: ObjectItemNotInContainer.TypeImpl) = create(onlySuccess, theObject)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


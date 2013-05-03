




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeReplyTaxVendorMessage extends MessageDeserializer {
  val messageId = 5787

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeReplyTaxVendorMessage.messageId

    val objectValue: Int
    val totalTaxValue: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objectValue)
      buf.writeInt(totalTaxValue)
    }

  }

  protected def create(objectValue: Int, totalTaxValue: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectValue = buf.readInt()
    val totalTaxValue = buf.readInt()

    create(objectValue, totalTaxValue)
  }

}

object ExchangeReplyTaxVendorMessage extends ExchangeReplyTaxVendorMessage {
  case class MessageImpl(objectValue: Int, totalTaxValue: Int) extends Message
  type Target = MessageImpl

  override def create(objectValue: Int, totalTaxValue: Int) = MessageImpl(objectValue, totalTaxValue)

  def apply(objectValue: Int, totalTaxValue: Int) = create(objectValue, totalTaxValue)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


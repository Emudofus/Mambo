




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismBalanceResultMessage extends MessageDeserializer {
  val messageId = 5841

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismBalanceResultMessage.messageId

    val totalBalanceValue: Byte
    val subAreaBalanceValue: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(totalBalanceValue)
      buf.writeByte(subAreaBalanceValue)
    }

  }

  protected def create(totalBalanceValue: Byte, subAreaBalanceValue: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val totalBalanceValue = buf.readByte()
    val subAreaBalanceValue = buf.readByte()

    create(totalBalanceValue, subAreaBalanceValue)
  }

}

object PrismBalanceResultMessage extends PrismBalanceResultMessage {
  case class MessageImpl(totalBalanceValue: Byte, subAreaBalanceValue: Byte) extends Message
  type Target = MessageImpl

  override def create(totalBalanceValue: Byte, subAreaBalanceValue: Byte) = MessageImpl(totalBalanceValue, subAreaBalanceValue)

  def apply(totalBalanceValue: Byte, subAreaBalanceValue: Byte) = create(totalBalanceValue, subAreaBalanceValue)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


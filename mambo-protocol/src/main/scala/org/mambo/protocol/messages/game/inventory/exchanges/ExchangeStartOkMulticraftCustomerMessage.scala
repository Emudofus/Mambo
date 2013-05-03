




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkMulticraftCustomerMessage extends MessageDeserializer {
  val messageId = 5817

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkMulticraftCustomerMessage.messageId

    val maxCase: Byte
    val skillId: Int
    val crafterJobLevel: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(maxCase)
      buf.writeInt(skillId)
      buf.writeByte(crafterJobLevel)
    }

  }

  protected def create(maxCase: Byte, skillId: Int, crafterJobLevel: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val maxCase = buf.readByte()
    val skillId = buf.readInt()
    val crafterJobLevel = buf.readByte()

    create(maxCase, skillId, crafterJobLevel)
  }

}

object ExchangeStartOkMulticraftCustomerMessage extends ExchangeStartOkMulticraftCustomerMessage {
  case class MessageImpl(maxCase: Byte, skillId: Int, crafterJobLevel: Byte) extends Message
  type Target = MessageImpl

  override def create(maxCase: Byte, skillId: Int, crafterJobLevel: Byte) = MessageImpl(maxCase, skillId, crafterJobLevel)

  def apply(maxCase: Byte, skillId: Int, crafterJobLevel: Byte) = create(maxCase, skillId, crafterJobLevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


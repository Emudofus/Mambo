




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeOkMultiCraftMessage extends MessageDeserializer {
  val messageId = 5768

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeOkMultiCraftMessage.messageId

    val initiatorId: Int
    val otherId: Int
    val role: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(initiatorId)
      buf.writeInt(otherId)
      buf.writeByte(role)
    }

  }

  protected def create(initiatorId: Int, otherId: Int, role: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val initiatorId = buf.readInt()
    val otherId = buf.readInt()
    val role = buf.readByte()

    create(initiatorId, otherId, role)
  }

}

object ExchangeOkMultiCraftMessage extends ExchangeOkMultiCraftMessage {
  case class MessageImpl(initiatorId: Int, otherId: Int, role: Byte) extends Message
  type Target = MessageImpl

  override def create(initiatorId: Int, otherId: Int, role: Byte) = MessageImpl(initiatorId, otherId, role)

  def apply(initiatorId: Int, otherId: Int, role: Byte) = create(initiatorId, otherId, role)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


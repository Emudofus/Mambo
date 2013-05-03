




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkMulticraftCrafterMessage extends MessageDeserializer {
  val messageId = 5818

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkMulticraftCrafterMessage.messageId

    val maxCase: Byte
    val skillId: Int

    def serialize(buf: Buffer) {
      buf.writeByte(maxCase)
      buf.writeInt(skillId)
    }

  }

  protected def create(maxCase: Byte, skillId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val maxCase = buf.readByte()
    val skillId = buf.readInt()

    create(maxCase, skillId)
  }

}

object ExchangeStartOkMulticraftCrafterMessage extends ExchangeStartOkMulticraftCrafterMessage {
  case class MessageImpl(maxCase: Byte, skillId: Int) extends Message
  type Target = MessageImpl

  override def create(maxCase: Byte, skillId: Int) = MessageImpl(maxCase, skillId)

  def apply(maxCase: Byte, skillId: Int) = create(maxCase, skillId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


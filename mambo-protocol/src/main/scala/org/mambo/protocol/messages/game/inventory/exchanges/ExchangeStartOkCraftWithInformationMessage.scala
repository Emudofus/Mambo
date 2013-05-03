




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkCraftWithInformationMessage extends ExchangeStartOkCraftMessage {
  override val messageId = 5941

  protected trait Message extends ExchangeStartOkCraftMessage.Message with Serializable {
    override val messageId = ExchangeStartOkCraftWithInformationMessage.messageId

    val nbCase: Byte
    val skillId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(nbCase)
      buf.writeInt(skillId)
    }

  }

  protected def create(nbCase: Byte, skillId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val nbCase = buf.readByte()
    val skillId = buf.readInt()

    create(nbCase, skillId)
  }

}

object ExchangeStartOkCraftWithInformationMessage extends ExchangeStartOkCraftWithInformationMessage {
  case class MessageImpl(nbCase: Byte, skillId: Int) extends Message
  type Target = MessageImpl

  override def create(nbCase: Byte, skillId: Int) = MessageImpl(nbCase, skillId)

  def apply(nbCase: Byte, skillId: Int) = create(nbCase, skillId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


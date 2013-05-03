




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeCraftResultMessage extends MessageDeserializer {
  val messageId = 5790

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeCraftResultMessage.messageId

    val craftResult: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(craftResult)
    }

  }

  protected def create(craftResult: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val craftResult = buf.readByte()

    create(craftResult)
  }

}

object ExchangeCraftResultMessage extends ExchangeCraftResultMessage {
  case class MessageImpl(craftResult: Byte) extends Message
  type Target = MessageImpl

  override def create(craftResult: Byte) = MessageImpl(craftResult)

  def apply(craftResult: Byte) = create(craftResult)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


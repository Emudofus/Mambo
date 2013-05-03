




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkNpcTradeMessage extends MessageDeserializer {
  val messageId = 5785

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkNpcTradeMessage.messageId

    val npcId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(npcId)
    }

  }

  protected def create(npcId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val npcId = buf.readInt()

    create(npcId)
  }

}

object ExchangeStartOkNpcTradeMessage extends ExchangeStartOkNpcTradeMessage {
  case class MessageImpl(npcId: Int) extends Message
  type Target = MessageImpl

  override def create(npcId: Int) = MessageImpl(npcId)

  def apply(npcId: Int) = create(npcId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


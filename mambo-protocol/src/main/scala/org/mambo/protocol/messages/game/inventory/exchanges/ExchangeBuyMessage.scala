




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBuyMessage extends MessageDeserializer {
  val messageId = 5774

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBuyMessage.messageId

    val objectToBuyId: Int
    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objectToBuyId)
      buf.writeInt(quantity)
    }

  }

  protected def create(objectToBuyId: Int, quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectToBuyId = buf.readInt()
    val quantity = buf.readInt()

    create(objectToBuyId, quantity)
  }

}

object ExchangeBuyMessage extends ExchangeBuyMessage {
  case class MessageImpl(objectToBuyId: Int, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(objectToBuyId: Int, quantity: Int) = MessageImpl(objectToBuyId, quantity)

  def apply(objectToBuyId: Int, quantity: Int) = create(objectToBuyId, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


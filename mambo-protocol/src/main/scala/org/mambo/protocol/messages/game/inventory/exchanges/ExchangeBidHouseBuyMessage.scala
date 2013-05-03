




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseBuyMessage extends MessageDeserializer {
  val messageId = 5804

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseBuyMessage.messageId

    val uid: Int
    val qty: Int
    val price: Int

    def serialize(buf: Buffer) {
      buf.writeInt(uid)
      buf.writeInt(qty)
      buf.writeInt(price)
    }

  }

  protected def create(uid: Int, qty: Int, price: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val qty = buf.readInt()
    val price = buf.readInt()

    create(uid, qty, price)
  }

}

object ExchangeBidHouseBuyMessage extends ExchangeBidHouseBuyMessage {
  case class MessageImpl(uid: Int, qty: Int, price: Int) extends Message
  type Target = MessageImpl

  override def create(uid: Int, qty: Int, price: Int) = MessageImpl(uid, qty, price)

  def apply(uid: Int, qty: Int, price: Int) = create(uid, qty, price)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


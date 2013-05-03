




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PurchasableDialogMessage extends MessageDeserializer {
  val messageId = 5739

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PurchasableDialogMessage.messageId

    val buyOrSell: Boolean
    val purchasableId: Int
    val price: Int

    def serialize(buf: Buffer) {
      buf.writeBoolean(buyOrSell)
      buf.writeInt(purchasableId)
      buf.writeInt(price)
    }

  }

  protected def create(buyOrSell: Boolean, purchasableId: Int, price: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val buyOrSell = buf.readBoolean()
    val purchasableId = buf.readInt()
    val price = buf.readInt()

    create(buyOrSell, purchasableId, price)
  }

}

object PurchasableDialogMessage extends PurchasableDialogMessage {
  case class MessageImpl(buyOrSell: Boolean, purchasableId: Int, price: Int) extends Message
  type Target = MessageImpl

  override def create(buyOrSell: Boolean, purchasableId: Int, price: Int) = MessageImpl(buyOrSell, purchasableId, price)

  def apply(buyOrSell: Boolean, purchasableId: Int, price: Int) = create(buyOrSell, purchasableId, price)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


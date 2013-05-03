




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockSellBuyDialogMessage extends MessageDeserializer {
  val messageId = 6018

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockSellBuyDialogMessage.messageId

    val bsell: Boolean
    val ownerId: Int
    val price: Int

    def serialize(buf: Buffer) {
      buf.writeBoolean(bsell)
      buf.writeInt(ownerId)
      buf.writeInt(price)
    }

  }

  protected def create(bsell: Boolean, ownerId: Int, price: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val bsell = buf.readBoolean()
    val ownerId = buf.readInt()
    val price = buf.readInt()

    create(bsell, ownerId, price)
  }

}

object PaddockSellBuyDialogMessage extends PaddockSellBuyDialogMessage {
  case class MessageImpl(bsell: Boolean, ownerId: Int, price: Int) extends Message
  type Target = MessageImpl

  override def create(bsell: Boolean, ownerId: Int, price: Int) = MessageImpl(bsell, ownerId, price)

  def apply(bsell: Boolean, ownerId: Int, price: Int) = create(bsell, ownerId, price)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


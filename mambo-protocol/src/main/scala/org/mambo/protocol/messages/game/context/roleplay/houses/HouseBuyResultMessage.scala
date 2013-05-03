




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseBuyResultMessage extends MessageDeserializer {
  val messageId = 5735

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseBuyResultMessage.messageId

    val houseId: Int
    val bought: Boolean
    val realPrice: Int

    def serialize(buf: Buffer) {
      buf.writeInt(houseId)
      buf.writeBoolean(bought)
      buf.writeInt(realPrice)
    }

  }

  protected def create(houseId: Int, bought: Boolean, realPrice: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readInt()
    val bought = buf.readBoolean()
    val realPrice = buf.readInt()

    create(houseId, bought, realPrice)
  }

}

object HouseBuyResultMessage extends HouseBuyResultMessage {
  case class MessageImpl(houseId: Int, bought: Boolean, realPrice: Int) extends Message
  type Target = MessageImpl

  override def create(houseId: Int, bought: Boolean, realPrice: Int) = MessageImpl(houseId, bought, realPrice)

  def apply(houseId: Int, bought: Boolean, realPrice: Int) = create(houseId, bought, realPrice)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


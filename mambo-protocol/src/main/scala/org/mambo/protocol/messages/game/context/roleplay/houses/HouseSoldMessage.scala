




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseSoldMessage extends MessageDeserializer {
  val messageId = 5737

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseSoldMessage.messageId

    val houseId: Int
    val realPrice: Int
    val buyerName: String

    def serialize(buf: Buffer) {
      buf.writeInt(houseId)
      buf.writeInt(realPrice)
      buf.writeString(buyerName)
    }

  }

  protected def create(houseId: Int, realPrice: Int, buyerName: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readInt()
    val realPrice = buf.readInt()
    val buyerName = buf.readString()

    create(houseId, realPrice, buyerName)
  }

}

object HouseSoldMessage extends HouseSoldMessage {
  case class MessageImpl(houseId: Int, realPrice: Int, buyerName: String) extends Message
  type Target = MessageImpl

  override def create(houseId: Int, realPrice: Int, buyerName: String) = MessageImpl(houseId, realPrice, buyerName)

  def apply(houseId: Int, realPrice: Int, buyerName: String) = create(houseId, realPrice, buyerName)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


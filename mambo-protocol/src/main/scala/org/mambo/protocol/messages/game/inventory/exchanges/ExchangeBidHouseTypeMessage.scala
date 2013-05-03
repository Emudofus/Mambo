




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseTypeMessage extends MessageDeserializer {
  val messageId = 5803

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseTypeMessage.messageId

    val theType: Int

    def serialize(buf: Buffer) {
      buf.writeInt(theType)
    }

  }

  protected def create(theType: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = buf.readInt()

    create(theType)
  }

}

object ExchangeBidHouseTypeMessage extends ExchangeBidHouseTypeMessage {
  case class MessageImpl(theType: Int) extends Message
  type Target = MessageImpl

  override def create(theType: Int) = MessageImpl(theType)

  def apply(theType: Int) = create(theType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


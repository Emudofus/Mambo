




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseSearchMessage extends MessageDeserializer {
  val messageId = 5806

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseSearchMessage.messageId

    val theType: Int
    val genId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(theType)
      buf.writeInt(genId)
    }

  }

  protected def create(theType: Int, genId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = buf.readInt()
    val genId = buf.readInt()

    create(theType, genId)
  }

}

object ExchangeBidHouseSearchMessage extends ExchangeBidHouseSearchMessage {
  case class MessageImpl(theType: Int, genId: Int) extends Message
  type Target = MessageImpl

  override def create(theType: Int, genId: Int) = MessageImpl(theType, genId)

  def apply(theType: Int, genId: Int) = create(theType, genId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


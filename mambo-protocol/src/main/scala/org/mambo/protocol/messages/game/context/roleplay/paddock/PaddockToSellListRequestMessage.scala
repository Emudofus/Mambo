




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockToSellListRequestMessage extends MessageDeserializer {
  val messageId = 6141

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockToSellListRequestMessage.messageId

    val pageIndex: Short

    def serialize(buf: Buffer) {
      buf.writeShort(pageIndex)
    }

  }

  protected def create(pageIndex: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val pageIndex = buf.readShort()

    create(pageIndex)
  }

}

object PaddockToSellListRequestMessage extends PaddockToSellListRequestMessage {
  case class MessageImpl(pageIndex: Short) extends Message
  type Target = MessageImpl

  override def create(pageIndex: Short) = MessageImpl(pageIndex)

  def apply(pageIndex: Short) = create(pageIndex)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


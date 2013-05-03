




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseBuyRequestMessage extends MessageDeserializer {
  val messageId = 5738

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseBuyRequestMessage.messageId

    val proposedPrice: Int

    def serialize(buf: Buffer) {
      buf.writeInt(proposedPrice)
    }

  }

  protected def create(proposedPrice: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val proposedPrice = buf.readInt()

    create(proposedPrice)
  }

}

object HouseBuyRequestMessage extends HouseBuyRequestMessage {
  case class MessageImpl(proposedPrice: Int) extends Message
  type Target = MessageImpl

  override def create(proposedPrice: Int) = MessageImpl(proposedPrice)

  def apply(proposedPrice: Int) = create(proposedPrice)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


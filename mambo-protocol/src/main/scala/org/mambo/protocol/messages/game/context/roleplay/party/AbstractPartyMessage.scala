




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AbstractPartyMessage extends MessageDeserializer {
  val messageId = 6274

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AbstractPartyMessage.messageId

    val partyId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(partyId)
    }

  }

  protected def create(partyId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()

    create(partyId)
  }

}

object AbstractPartyMessage extends AbstractPartyMessage {
  case class MessageImpl(partyId: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int) = MessageImpl(partyId)

  def apply(partyId: Int) = create(partyId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectUseMultipleMessage extends ObjectUseMessage {
  override val messageId = 6234

  protected trait Message extends ObjectUseMessage.Message with Serializable {
    override val messageId = ObjectUseMultipleMessage.messageId

    val quantity: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(quantity)
    }

  }

  protected def create(objectUID: Int, quantity: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val quantity = buf.readInt()

    create(objectUID, quantity)
  }

}

object ObjectUseMultipleMessage extends ObjectUseMultipleMessage {
  case class MessageImpl(objectUID: Int, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, quantity: Int) = MessageImpl(objectUID, quantity)

  def apply(objectUID: Int, quantity: Int) = create(objectUID, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


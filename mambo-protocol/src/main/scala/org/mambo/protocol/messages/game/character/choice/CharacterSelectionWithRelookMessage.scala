




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterSelectionWithRelookMessage extends CharacterSelectionMessage {
  override val messageId = 6353

  protected trait Message extends CharacterSelectionMessage.Message with Serializable {
    override val messageId = CharacterSelectionWithRelookMessage.messageId

    val cosmeticId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(cosmeticId)
    }

  }

  protected def create(id: Int, cosmeticId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val cosmeticId = buf.readInt()

    create(id, cosmeticId)
  }

}

object CharacterSelectionWithRelookMessage extends CharacterSelectionWithRelookMessage {
  case class MessageImpl(id: Int, cosmeticId: Int) extends Message
  type Target = MessageImpl

  override def create(id: Int, cosmeticId: Int) = MessageImpl(id, cosmeticId)

  def apply(id: Int, cosmeticId: Int) = create(id, cosmeticId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterReplayWithRelookRequestMessage extends CharacterReplayRequestMessage {
  override val messageId = 6354

  protected trait Message extends CharacterReplayRequestMessage.Message with Serializable {
    override val messageId = CharacterReplayWithRelookRequestMessage.messageId

    val cosmeticId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(cosmeticId)
    }

  }

  protected def create(characterId: Int, cosmeticId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val characterId = buf.readInt()
    val cosmeticId = buf.readInt()

    create(characterId, cosmeticId)
  }

}

object CharacterReplayWithRelookRequestMessage extends CharacterReplayWithRelookRequestMessage {
  case class MessageImpl(characterId: Int, cosmeticId: Int) extends Message
  type Target = MessageImpl

  override def create(characterId: Int, cosmeticId: Int) = MessageImpl(characterId, cosmeticId)

  def apply(characterId: Int, cosmeticId: Int) = create(characterId, cosmeticId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


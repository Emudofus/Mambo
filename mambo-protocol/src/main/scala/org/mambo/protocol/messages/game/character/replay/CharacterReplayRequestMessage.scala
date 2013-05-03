




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterReplayRequestMessage extends MessageDeserializer {
  val messageId = 167

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterReplayRequestMessage.messageId

    val characterId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(characterId)
    }

  }

  protected def create(characterId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val characterId = buf.readInt()

    create(characterId)
  }

}

object CharacterReplayRequestMessage extends CharacterReplayRequestMessage {
  case class MessageImpl(characterId: Int) extends Message
  type Target = MessageImpl

  override def create(characterId: Int) = MessageImpl(characterId)

  def apply(characterId: Int) = create(characterId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


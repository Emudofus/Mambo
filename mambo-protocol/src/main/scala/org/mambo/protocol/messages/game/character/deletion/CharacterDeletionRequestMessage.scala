




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterDeletionRequestMessage extends MessageDeserializer {
  val messageId = 165

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterDeletionRequestMessage.messageId

    val characterId: Int
    val secretAnswerHash: String

    def serialize(buf: Buffer) {
      buf.writeInt(characterId)
      buf.writeString(secretAnswerHash)
    }

  }

  protected def create(characterId: Int, secretAnswerHash: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val characterId = buf.readInt()
    val secretAnswerHash = buf.readString()

    create(characterId, secretAnswerHash)
  }

}

object CharacterDeletionRequestMessage extends CharacterDeletionRequestMessage {
  case class MessageImpl(characterId: Int, secretAnswerHash: String) extends Message
  type Target = MessageImpl

  override def create(characterId: Int, secretAnswerHash: String) = MessageImpl(characterId, secretAnswerHash)

  def apply(characterId: Int, secretAnswerHash: String) = create(characterId, secretAnswerHash)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


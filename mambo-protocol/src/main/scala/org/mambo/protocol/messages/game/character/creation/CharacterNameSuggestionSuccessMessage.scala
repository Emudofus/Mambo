




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterNameSuggestionSuccessMessage extends MessageDeserializer {
  val messageId = 5544

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterNameSuggestionSuccessMessage.messageId

    val suggestion: String

    def serialize(buf: Buffer) {
      buf.writeString(suggestion)
    }

  }

  protected def create(suggestion: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val suggestion = buf.readString()

    create(suggestion)
  }

}

object CharacterNameSuggestionSuccessMessage extends CharacterNameSuggestionSuccessMessage {
  case class MessageImpl(suggestion: String) extends Message
  type Target = MessageImpl

  override def create(suggestion: String) = MessageImpl(suggestion)

  def apply(suggestion: String) = create(suggestion)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


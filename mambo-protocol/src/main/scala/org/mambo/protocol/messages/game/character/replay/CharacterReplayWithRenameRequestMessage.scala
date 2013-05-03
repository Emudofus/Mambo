




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterReplayWithRenameRequestMessage extends CharacterReplayRequestMessage {
  override val messageId = 6122

  protected trait Message extends CharacterReplayRequestMessage.Message with Serializable {
    override val messageId = CharacterReplayWithRenameRequestMessage.messageId

    val name: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
    }

  }

  protected def create(characterId: Int, name: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val characterId = buf.readInt()
    val name = buf.readString()

    create(characterId, name)
  }

}

object CharacterReplayWithRenameRequestMessage extends CharacterReplayWithRenameRequestMessage {
  case class MessageImpl(characterId: Int, name: String) extends Message
  type Target = MessageImpl

  override def create(characterId: Int, name: String) = MessageImpl(characterId, name)

  def apply(characterId: Int, name: String) = create(characterId, name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


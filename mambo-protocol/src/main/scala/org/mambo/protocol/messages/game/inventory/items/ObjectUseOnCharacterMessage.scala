




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectUseOnCharacterMessage extends ObjectUseMessage {
  override val messageId = 3003

  protected trait Message extends ObjectUseMessage.Message with Serializable {
    override val messageId = ObjectUseOnCharacterMessage.messageId

    val characterId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(characterId)
    }

  }

  protected def create(objectUID: Int, characterId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val characterId = buf.readInt()

    create(objectUID, characterId)
  }

}

object ObjectUseOnCharacterMessage extends ObjectUseOnCharacterMessage {
  case class MessageImpl(objectUID: Int, characterId: Int) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, characterId: Int) = MessageImpl(objectUID, characterId)

  def apply(objectUID: Int, characterId: Int) = create(objectUID, characterId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightHumanReadyStateMessage extends MessageDeserializer {
  val messageId = 740

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightHumanReadyStateMessage.messageId

    val characterId: Int
    val isReady: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(characterId)
      buf.writeBoolean(isReady)
    }

  }

  protected def create(characterId: Int, isReady: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val characterId = buf.readInt()
    val isReady = buf.readBoolean()

    create(characterId, isReady)
  }

}

object GameFightHumanReadyStateMessage extends GameFightHumanReadyStateMessage {
  case class MessageImpl(characterId: Int, isReady: Boolean) extends Message
  type Target = MessageImpl

  override def create(characterId: Int, isReady: Boolean) = MessageImpl(characterId, isReady)

  def apply(characterId: Int, isReady: Boolean) = create(characterId, isReady)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


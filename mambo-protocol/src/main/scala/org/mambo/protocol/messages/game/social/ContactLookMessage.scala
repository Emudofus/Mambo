




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ContactLookMessage extends MessageDeserializer {
  val messageId = 5934

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ContactLookMessage.messageId

    val requestId: Int
    val playerName: String
    val playerId: Int
    val look: EntityLook.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeInt(requestId)
      buf.writeString(playerName)
      buf.writeInt(playerId)
      look.serialize(buf)
    }

  }

  protected def create(requestId: Int, playerName: String, playerId: Int, look: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val requestId = buf.readInt()
    val playerName = buf.readString()
    val playerId = buf.readInt()
    val look = EntityLook.deserialize(buf)

    create(requestId, playerName, playerId, look)
  }

}

object ContactLookMessage extends ContactLookMessage {
  case class MessageImpl(requestId: Int, playerName: String, playerId: Int, look: EntityLook.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(requestId: Int, playerName: String, playerId: Int, look: EntityLook.TypeImpl) = MessageImpl(requestId, playerName, playerId, look)

  def apply(requestId: Int, playerName: String, playerId: Int, look: EntityLook.TypeImpl) = create(requestId, playerName, playerId, look)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


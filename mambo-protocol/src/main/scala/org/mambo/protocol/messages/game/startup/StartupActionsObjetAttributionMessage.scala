




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StartupActionsObjetAttributionMessage extends MessageDeserializer {
  val messageId = 1303

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StartupActionsObjetAttributionMessage.messageId

    val actionId: Int
    val characterId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(actionId)
      buf.writeInt(characterId)
    }

  }

  protected def create(actionId: Int, characterId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actionId = buf.readInt()
    val characterId = buf.readInt()

    create(actionId, characterId)
  }

}

object StartupActionsObjetAttributionMessage extends StartupActionsObjetAttributionMessage {
  case class MessageImpl(actionId: Int, characterId: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Int, characterId: Int) = MessageImpl(actionId, characterId)

  def apply(actionId: Int, characterId: Int) = create(actionId, characterId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


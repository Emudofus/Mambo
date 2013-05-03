




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightTurnReadyMessage extends MessageDeserializer {
  val messageId = 716

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightTurnReadyMessage.messageId

    val isReady: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(isReady)
    }

  }

  protected def create(isReady: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val isReady = buf.readBoolean()

    create(isReady)
  }

}

object GameFightTurnReadyMessage extends GameFightTurnReadyMessage {
  case class MessageImpl(isReady: Boolean) extends Message
  type Target = MessageImpl

  override def create(isReady: Boolean) = MessageImpl(isReady)

  def apply(isReady: Boolean) = create(isReady)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeResultMessage extends MessageDeserializer {
  val messageId = 6019

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeResultMessage.messageId

    val challengeId: Short
    val success: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(challengeId)
      buf.writeBoolean(success)
    }

  }

  protected def create(challengeId: Short, success: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val challengeId = buf.readShort()
    val success = buf.readBoolean()

    create(challengeId, success)
  }

}

object ChallengeResultMessage extends ChallengeResultMessage {
  case class MessageImpl(challengeId: Short, success: Boolean) extends Message
  type Target = MessageImpl

  override def create(challengeId: Short, success: Boolean) = MessageImpl(challengeId, success)

  def apply(challengeId: Short, success: Boolean) = create(challengeId, success)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


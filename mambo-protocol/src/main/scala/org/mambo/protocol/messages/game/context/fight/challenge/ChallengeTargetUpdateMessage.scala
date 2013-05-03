




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeTargetUpdateMessage extends MessageDeserializer {
  val messageId = 6123

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeTargetUpdateMessage.messageId

    val challengeId: Short
    val targetId: Int

    def serialize(buf: Buffer) {
      buf.writeShort(challengeId)
      buf.writeInt(targetId)
    }

  }

  protected def create(challengeId: Short, targetId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val challengeId = buf.readShort()
    val targetId = buf.readInt()

    create(challengeId, targetId)
  }

}

object ChallengeTargetUpdateMessage extends ChallengeTargetUpdateMessage {
  case class MessageImpl(challengeId: Short, targetId: Int) extends Message
  type Target = MessageImpl

  override def create(challengeId: Short, targetId: Int) = MessageImpl(challengeId, targetId)

  def apply(challengeId: Short, targetId: Int) = create(challengeId, targetId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


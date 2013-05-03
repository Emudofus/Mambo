




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeTargetsListRequestMessage extends MessageDeserializer {
  val messageId = 5614

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeTargetsListRequestMessage.messageId

    val challengeId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(challengeId)
    }

  }

  protected def create(challengeId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val challengeId = buf.readShort()

    create(challengeId)
  }

}

object ChallengeTargetsListRequestMessage extends ChallengeTargetsListRequestMessage {
  case class MessageImpl(challengeId: Short) extends Message
  type Target = MessageImpl

  override def create(challengeId: Short) = MessageImpl(challengeId)

  def apply(challengeId: Short) = create(challengeId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayShowChallengeMessage extends MessageDeserializer {
  val messageId = 301

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayShowChallengeMessage.messageId

    val commonsInfos: FightCommonInformations.TypeImpl

    def serialize(buf: Buffer) {
      commonsInfos.serialize(buf)
    }

  }

  protected def create(commonsInfos: FightCommonInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val commonsInfos = FightCommonInformations.deserialize(buf)

    create(commonsInfos)
  }

}

object GameRolePlayShowChallengeMessage extends GameRolePlayShowChallengeMessage {
  case class MessageImpl(commonsInfos: FightCommonInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(commonsInfos: FightCommonInformations.TypeImpl) = MessageImpl(commonsInfos)

  def apply(commonsInfos: FightCommonInformations.TypeImpl) = create(commonsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


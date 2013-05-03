




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeInfoMessage extends MessageDeserializer {
  val messageId = 6022

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeInfoMessage.messageId

    val challengeId: Short
    val targetId: Int
    val baseXpBonus: Int
    val extraXpBonus: Int
    val baseDropBonus: Int
    val extraDropBonus: Int

    def serialize(buf: Buffer) {
      buf.writeShort(challengeId)
      buf.writeInt(targetId)
      buf.writeInt(baseXpBonus)
      buf.writeInt(extraXpBonus)
      buf.writeInt(baseDropBonus)
      buf.writeInt(extraDropBonus)
    }

  }

  protected def create(challengeId: Short, targetId: Int, baseXpBonus: Int, extraXpBonus: Int, baseDropBonus: Int, extraDropBonus: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val challengeId = buf.readShort()
    val targetId = buf.readInt()
    val baseXpBonus = buf.readInt()
    val extraXpBonus = buf.readInt()
    val baseDropBonus = buf.readInt()
    val extraDropBonus = buf.readInt()

    create(challengeId, targetId, baseXpBonus, extraXpBonus, baseDropBonus, extraDropBonus)
  }

}

object ChallengeInfoMessage extends ChallengeInfoMessage {
  case class MessageImpl(challengeId: Short, targetId: Int, baseXpBonus: Int, extraXpBonus: Int, baseDropBonus: Int, extraDropBonus: Int) extends Message
  type Target = MessageImpl

  override def create(challengeId: Short, targetId: Int, baseXpBonus: Int, extraXpBonus: Int, baseDropBonus: Int, extraDropBonus: Int) = MessageImpl(challengeId, targetId, baseXpBonus, extraXpBonus, baseDropBonus, extraDropBonus)

  def apply(challengeId: Short, targetId: Int, baseXpBonus: Int, extraXpBonus: Int, baseDropBonus: Int, extraDropBonus: Int) = create(challengeId, targetId, baseXpBonus, extraXpBonus, baseDropBonus, extraDropBonus)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


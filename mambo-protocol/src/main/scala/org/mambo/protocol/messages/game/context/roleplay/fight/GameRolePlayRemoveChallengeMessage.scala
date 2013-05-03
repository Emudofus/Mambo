




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayRemoveChallengeMessage extends MessageDeserializer {
  val messageId = 300

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayRemoveChallengeMessage.messageId

    val fightId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
    }

  }

  protected def create(fightId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()

    create(fightId)
  }

}

object GameRolePlayRemoveChallengeMessage extends GameRolePlayRemoveChallengeMessage {
  case class MessageImpl(fightId: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Int) = MessageImpl(fightId)

  def apply(fightId: Int) = create(fightId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


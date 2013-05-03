




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayPlayerFightFriendlyAnswerMessage extends MessageDeserializer {
  val messageId = 5732

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayPlayerFightFriendlyAnswerMessage.messageId

    val fightId: Int
    val accept: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeBoolean(accept)
    }

  }

  protected def create(fightId: Int, accept: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val accept = buf.readBoolean()

    create(fightId, accept)
  }

}

object GameRolePlayPlayerFightFriendlyAnswerMessage extends GameRolePlayPlayerFightFriendlyAnswerMessage {
  case class MessageImpl(fightId: Int, accept: Boolean) extends Message
  type Target = MessageImpl

  override def create(fightId: Int, accept: Boolean) = MessageImpl(fightId, accept)

  def apply(fightId: Int, accept: Boolean) = create(fightId, accept)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


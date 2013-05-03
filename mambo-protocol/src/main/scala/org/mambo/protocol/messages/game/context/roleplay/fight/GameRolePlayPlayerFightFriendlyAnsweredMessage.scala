




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayPlayerFightFriendlyAnsweredMessage extends MessageDeserializer {
  val messageId = 5733

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayPlayerFightFriendlyAnsweredMessage.messageId

    val fightId: Int
    val sourceId: Int
    val targetId: Int
    val accept: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeInt(sourceId)
      buf.writeInt(targetId)
      buf.writeBoolean(accept)
    }

  }

  protected def create(fightId: Int, sourceId: Int, targetId: Int, accept: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val accept = buf.readBoolean()

    create(fightId, sourceId, targetId, accept)
  }

}

object GameRolePlayPlayerFightFriendlyAnsweredMessage extends GameRolePlayPlayerFightFriendlyAnsweredMessage {
  case class MessageImpl(fightId: Int, sourceId: Int, targetId: Int, accept: Boolean) extends Message
  type Target = MessageImpl

  override def create(fightId: Int, sourceId: Int, targetId: Int, accept: Boolean) = MessageImpl(fightId, sourceId, targetId, accept)

  def apply(fightId: Int, sourceId: Int, targetId: Int, accept: Boolean) = create(fightId, sourceId, targetId, accept)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


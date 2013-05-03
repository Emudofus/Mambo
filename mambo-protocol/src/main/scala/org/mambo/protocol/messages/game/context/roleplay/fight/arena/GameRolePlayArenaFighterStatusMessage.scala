




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayArenaFighterStatusMessage extends MessageDeserializer {
  val messageId = 6281

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayArenaFighterStatusMessage.messageId

    val fightId: Int
    val playerId: Int
    val accepted: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeInt(playerId)
      buf.writeBoolean(accepted)
    }

  }

  protected def create(fightId: Int, playerId: Int, accepted: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val playerId = buf.readInt()
    val accepted = buf.readBoolean()

    create(fightId, playerId, accepted)
  }

}

object GameRolePlayArenaFighterStatusMessage extends GameRolePlayArenaFighterStatusMessage {
  case class MessageImpl(fightId: Int, playerId: Int, accepted: Boolean) extends Message
  type Target = MessageImpl

  override def create(fightId: Int, playerId: Int, accepted: Boolean) = MessageImpl(fightId, playerId, accepted)

  def apply(fightId: Int, playerId: Int, accepted: Boolean) = create(fightId, playerId, accepted)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


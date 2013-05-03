




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildFightPlayersHelpersLeaveMessage extends MessageDeserializer {
  val messageId = 5719

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildFightPlayersHelpersLeaveMessage.messageId

    val fightId: Double
    val playerId: Int

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeInt(playerId)
    }

  }

  protected def create(fightId: Double, playerId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val playerId = buf.readInt()

    create(fightId, playerId)
  }

}

object GuildFightPlayersHelpersLeaveMessage extends GuildFightPlayersHelpersLeaveMessage {
  case class MessageImpl(fightId: Double, playerId: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, playerId: Int) = MessageImpl(fightId, playerId)

  def apply(fightId: Double, playerId: Int) = create(fightId, playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


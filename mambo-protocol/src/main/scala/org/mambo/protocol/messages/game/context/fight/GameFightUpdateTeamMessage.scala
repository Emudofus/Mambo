




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightUpdateTeamMessage extends MessageDeserializer {
  val messageId = 5572

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightUpdateTeamMessage.messageId

    val fightId: Short
    val team: FightTeamInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeShort(fightId)
      team.serialize(buf)
    }

  }

  protected def create(fightId: Short, team: FightTeamInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readShort()
    val team = FightTeamInformations.deserialize(buf)

    create(fightId, team)
  }

}

object GameFightUpdateTeamMessage extends GameFightUpdateTeamMessage {
  case class MessageImpl(fightId: Short, team: FightTeamInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(fightId: Short, team: FightTeamInformations.TypeImpl) = MessageImpl(fightId, team)

  def apply(fightId: Short, team: FightTeamInformations.TypeImpl) = create(fightId, team)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightRemoveTeamMemberMessage extends MessageDeserializer {
  val messageId = 711

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightRemoveTeamMemberMessage.messageId

    val fightId: Short
    val teamId: Byte
    val charId: Int

    def serialize(buf: Buffer) {
      buf.writeShort(fightId)
      buf.writeByte(teamId)
      buf.writeInt(charId)
    }

  }

  protected def create(fightId: Short, teamId: Byte, charId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readShort()
    val teamId = buf.readByte()
    val charId = buf.readInt()

    create(fightId, teamId, charId)
  }

}

object GameFightRemoveTeamMemberMessage extends GameFightRemoveTeamMemberMessage {
  case class MessageImpl(fightId: Short, teamId: Byte, charId: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Short, teamId: Byte, charId: Int) = MessageImpl(fightId, teamId, charId)

  def apply(fightId: Short, teamId: Byte, charId: Int) = create(fightId, teamId, charId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


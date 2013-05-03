




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightOptionStateUpdateMessage extends MessageDeserializer {
  val messageId = 5927

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightOptionStateUpdateMessage.messageId

    val fightId: Short
    val teamId: Byte
    val option: Byte
    val state: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(fightId)
      buf.writeByte(teamId)
      buf.writeByte(option)
      buf.writeBoolean(state)
    }

  }

  protected def create(fightId: Short, teamId: Byte, option: Byte, state: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readShort()
    val teamId = buf.readByte()
    val option = buf.readByte()
    val state = buf.readBoolean()

    create(fightId, teamId, option, state)
  }

}

object GameFightOptionStateUpdateMessage extends GameFightOptionStateUpdateMessage {
  case class MessageImpl(fightId: Short, teamId: Byte, option: Byte, state: Boolean) extends Message
  type Target = MessageImpl

  override def create(fightId: Short, teamId: Byte, option: Byte, state: Boolean) = MessageImpl(fightId, teamId, option, state)

  def apply(fightId: Short, teamId: Byte, option: Byte, state: Boolean) = create(fightId, teamId, option, state)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


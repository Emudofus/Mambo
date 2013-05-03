




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyInvitationDungeonRequestMessage extends PartyInvitationRequestMessage {
  override val messageId = 6245

  protected trait Message extends PartyInvitationRequestMessage.Message with Serializable {
    override val messageId = PartyInvitationDungeonRequestMessage.messageId

    val dungeonId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(dungeonId)
    }

  }

  protected def create(name: String, dungeonId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val dungeonId = buf.readShort()

    create(name, dungeonId)
  }

}

object PartyInvitationDungeonRequestMessage extends PartyInvitationDungeonRequestMessage {
  case class MessageImpl(name: String, dungeonId: Short) extends Message
  type Target = MessageImpl

  override def create(name: String, dungeonId: Short) = MessageImpl(name, dungeonId)

  def apply(name: String, dungeonId: Short) = create(name, dungeonId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


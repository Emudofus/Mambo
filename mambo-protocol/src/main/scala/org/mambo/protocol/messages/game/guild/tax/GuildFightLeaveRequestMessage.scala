




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildFightLeaveRequestMessage extends MessageDeserializer {
  val messageId = 5715

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildFightLeaveRequestMessage.messageId

    val taxCollectorId: Int
    val characterId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(taxCollectorId)
      buf.writeInt(characterId)
    }

  }

  protected def create(taxCollectorId: Int, characterId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val taxCollectorId = buf.readInt()
    val characterId = buf.readInt()

    create(taxCollectorId, characterId)
  }

}

object GuildFightLeaveRequestMessage extends GuildFightLeaveRequestMessage {
  case class MessageImpl(taxCollectorId: Int, characterId: Int) extends Message
  type Target = MessageImpl

  override def create(taxCollectorId: Int, characterId: Int) = MessageImpl(taxCollectorId, characterId)

  def apply(taxCollectorId: Int, characterId: Int) = create(taxCollectorId, characterId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}























// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildFightTakePlaceRequestMessage extends GuildFightJoinRequestMessage {
  override val messageId = 6235

  protected trait Message extends GuildFightJoinRequestMessage.Message with Serializable {
    override val messageId = GuildFightTakePlaceRequestMessage.messageId

    val replacedCharacterId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(replacedCharacterId)
    }

  }

  protected def create(taxCollectorId: Int, replacedCharacterId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val taxCollectorId = buf.readInt()
    val replacedCharacterId = buf.readInt()

    create(taxCollectorId, replacedCharacterId)
  }

}

object GuildFightTakePlaceRequestMessage extends GuildFightTakePlaceRequestMessage {
  case class MessageImpl(taxCollectorId: Int, replacedCharacterId: Int) extends Message
  type Target = MessageImpl

  override def create(taxCollectorId: Int, replacedCharacterId: Int) = MessageImpl(taxCollectorId, replacedCharacterId)

  def apply(taxCollectorId: Int, replacedCharacterId: Int) = create(taxCollectorId, replacedCharacterId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


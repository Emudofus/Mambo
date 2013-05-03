




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildHouseTeleportRequestMessage extends MessageDeserializer {
  val messageId = 5712

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildHouseTeleportRequestMessage.messageId

    val houseId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(houseId)
    }

  }

  protected def create(houseId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readInt()

    create(houseId)
  }

}

object GuildHouseTeleportRequestMessage extends GuildHouseTeleportRequestMessage {
  case class MessageImpl(houseId: Int) extends Message
  type Target = MessageImpl

  override def create(houseId: Int) = MessageImpl(houseId)

  def apply(houseId: Int) = create(houseId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


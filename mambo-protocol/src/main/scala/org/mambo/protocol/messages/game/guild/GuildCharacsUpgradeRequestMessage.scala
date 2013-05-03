




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildCharacsUpgradeRequestMessage extends MessageDeserializer {
  val messageId = 5706

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildCharacsUpgradeRequestMessage.messageId

    val charaTypeTarget: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(charaTypeTarget)
    }

  }

  protected def create(charaTypeTarget: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val charaTypeTarget = buf.readByte()

    create(charaTypeTarget)
  }

}

object GuildCharacsUpgradeRequestMessage extends GuildCharacsUpgradeRequestMessage {
  case class MessageImpl(charaTypeTarget: Byte) extends Message
  type Target = MessageImpl

  override def create(charaTypeTarget: Byte) = MessageImpl(charaTypeTarget)

  def apply(charaTypeTarget: Byte) = create(charaTypeTarget)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


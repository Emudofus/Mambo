




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ServerSettingsMessage extends MessageDeserializer {
  val messageId = 6340

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ServerSettingsMessage.messageId

    val lang: String
    val community: Byte

    def serialize(buf: Buffer) {
      buf.writeString(lang)
      buf.writeByte(community)
    }

  }

  protected def create(lang: String, community: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val lang = buf.readString()
    val community = buf.readByte()

    create(lang, community)
  }

}

object ServerSettingsMessage extends ServerSettingsMessage {
  case class MessageImpl(lang: String, community: Byte) extends Message
  type Target = MessageImpl

  override def create(lang: String, community: Byte) = MessageImpl(lang, community)

  def apply(lang: String, community: Byte) = create(lang, community)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


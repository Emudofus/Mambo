




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildGetInformationsMessage extends MessageDeserializer {
  val messageId = 5550

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildGetInformationsMessage.messageId

    val infoType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(infoType)
    }

  }

  protected def create(infoType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val infoType = buf.readByte()

    create(infoType)
  }

}

object GuildGetInformationsMessage extends GuildGetInformationsMessage {
  case class MessageImpl(infoType: Byte) extends Message
  type Target = MessageImpl

  override def create(infoType: Byte) = MessageImpl(infoType)

  def apply(infoType: Byte) = create(infoType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


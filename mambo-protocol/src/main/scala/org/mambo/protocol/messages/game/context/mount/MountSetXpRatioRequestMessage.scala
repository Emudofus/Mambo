




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountSetXpRatioRequestMessage extends MessageDeserializer {
  val messageId = 5989

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountSetXpRatioRequestMessage.messageId

    val xpRatio: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(xpRatio)
    }

  }

  protected def create(xpRatio: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val xpRatio = buf.readByte()

    create(xpRatio)
  }

}

object MountSetXpRatioRequestMessage extends MountSetXpRatioRequestMessage {
  case class MessageImpl(xpRatio: Byte) extends Message
  type Target = MessageImpl

  override def create(xpRatio: Byte) = MessageImpl(xpRatio)

  def apply(xpRatio: Byte) = create(xpRatio)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


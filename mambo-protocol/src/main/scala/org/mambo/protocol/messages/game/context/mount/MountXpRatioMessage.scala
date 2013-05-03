




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountXpRatioMessage extends MessageDeserializer {
  val messageId = 5970

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountXpRatioMessage.messageId

    val ratio: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(ratio)
    }

  }

  protected def create(ratio: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ratio = buf.readByte()

    create(ratio)
  }

}

object MountXpRatioMessage extends MountXpRatioMessage {
  case class MessageImpl(ratio: Byte) extends Message
  type Target = MessageImpl

  override def create(ratio: Byte) = MessageImpl(ratio)

  def apply(ratio: Byte) = create(ratio)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


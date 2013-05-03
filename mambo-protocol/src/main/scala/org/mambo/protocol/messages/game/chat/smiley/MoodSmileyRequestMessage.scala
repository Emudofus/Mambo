




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MoodSmileyRequestMessage extends MessageDeserializer {
  val messageId = 6192

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MoodSmileyRequestMessage.messageId

    val smileyId: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(smileyId)
    }

  }

  protected def create(smileyId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val smileyId = buf.readByte()

    create(smileyId)
  }

}

object MoodSmileyRequestMessage extends MoodSmileyRequestMessage {
  case class MessageImpl(smileyId: Byte) extends Message
  type Target = MessageImpl

  override def create(smileyId: Byte) = MessageImpl(smileyId)

  def apply(smileyId: Byte) = create(smileyId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


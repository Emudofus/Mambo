




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MoodSmileyResultMessage extends MessageDeserializer {
  val messageId = 6196

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MoodSmileyResultMessage.messageId

    val resultCode: Byte
    val smileyId: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(resultCode)
      buf.writeByte(smileyId)
    }

  }

  protected def create(resultCode: Byte, smileyId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val resultCode = buf.readByte()
    val smileyId = buf.readByte()

    create(resultCode, smileyId)
  }

}

object MoodSmileyResultMessage extends MoodSmileyResultMessage {
  case class MessageImpl(resultCode: Byte, smileyId: Byte) extends Message
  type Target = MessageImpl

  override def create(resultCode: Byte, smileyId: Byte) = MessageImpl(resultCode, smileyId)

  def apply(resultCode: Byte, smileyId: Byte) = create(resultCode, smileyId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


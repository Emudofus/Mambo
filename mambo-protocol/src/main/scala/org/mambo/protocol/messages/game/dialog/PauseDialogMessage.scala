




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PauseDialogMessage extends MessageDeserializer {
  val messageId = 6012

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PauseDialogMessage.messageId

    val dialogType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(dialogType)
    }

  }

  protected def create(dialogType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dialogType = buf.readByte()

    create(dialogType)
  }

}

object PauseDialogMessage extends PauseDialogMessage {
  case class MessageImpl(dialogType: Byte) extends Message
  type Target = MessageImpl

  override def create(dialogType: Byte) = MessageImpl(dialogType)

  def apply(dialogType: Byte) = create(dialogType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


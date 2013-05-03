




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeLeaveMessage extends LeaveDialogMessage {
  override val messageId = 5628

  protected trait Message extends LeaveDialogMessage.Message with Serializable {
    override val messageId = ExchangeLeaveMessage.messageId

    val success: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(success)
    }

  }

  protected def create(dialogType: Byte, success: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val dialogType = buf.readByte()
    val success = buf.readBoolean()

    create(dialogType, success)
  }

}

object ExchangeLeaveMessage extends ExchangeLeaveMessage {
  case class MessageImpl(dialogType: Byte, success: Boolean) extends Message
  type Target = MessageImpl

  override def create(dialogType: Byte, success: Boolean) = MessageImpl(dialogType, success)

  def apply(dialogType: Byte, success: Boolean) = create(dialogType, success)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}


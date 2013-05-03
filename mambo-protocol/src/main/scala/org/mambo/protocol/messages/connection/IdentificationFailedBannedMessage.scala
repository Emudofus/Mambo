




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IdentificationFailedBannedMessage extends IdentificationFailedMessage {
  override val messageId = 6174

  protected trait Message extends IdentificationFailedMessage.Message with Serializable {
    override val messageId = IdentificationFailedBannedMessage.messageId

    val banEndDate: Double

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeDouble(banEndDate)
    }

  }

  protected def create(reason: Byte, banEndDate: Double): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val reason = buf.readByte()
    val banEndDate = buf.readDouble()

    create(reason, banEndDate)
  }

}

object IdentificationFailedBannedMessage extends IdentificationFailedBannedMessage {
  case class MessageImpl(reason: Byte, banEndDate: Double) extends Message
  type Target = MessageImpl

  override def create(reason: Byte, banEndDate: Double) = MessageImpl(reason, banEndDate)

  def apply(reason: Byte, banEndDate: Double) = create(reason, banEndDate)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

